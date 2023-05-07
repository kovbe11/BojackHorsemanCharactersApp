package hu.bme.aut.android.bojackhorseman.interactor

import android.util.Log
import hu.bme.aut.android.bojackhorseman.model.Character
import hu.bme.aut.android.bojackhorseman.network.CharacterDTO
import hu.bme.aut.android.bojackhorseman.network.CharactersApi
import hu.bme.aut.android.bojackhorseman.network.toDTO
import hu.bme.aut.android.bojackhorseman.persistence.CharactersDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import javax.inject.Inject

class CharactersInteractor @Inject constructor(
    private val charactersDao: CharactersDao,
    private val charactersApi: CharactersApi
) {

    suspend fun createCharacter(character: Character): Unit = withContext(Dispatchers.IO) {
        charactersDao.create(character)
        callApiOrIgnoreError { charactersApi.create(character.toDTO()) }
    }

    suspend fun getCharacters(): List<Character> = withContext(Dispatchers.IO) {
        val dbData = charactersDao.findAll()
        val apiData = callApiOrIgnoreError { charactersApi.findAll() }

        return@withContext updateOrLoadCache(dbData, apiData)
    }

    suspend fun updateCharacter(character: Character): Unit = withContext(Dispatchers.IO) {
        charactersDao.update(character)
        callApiOrIgnoreError { charactersApi.update(character.toDTO()) }
    }

    suspend fun deleteCharacter(character: Character): Unit = withContext(Dispatchers.IO) {
        charactersDao.delete(character)
        callApiOrIgnoreError { charactersApi.delete(character.id) }
    }

    private suspend fun updateOrLoadCache(
        dbCharacters: List<Character>,
        charactersResponse: Response<List<CharacterDTO>>
    ): List<Character> {
        if (!charactersResponse.isSuccessful) return dbCharacters
        val characters = charactersResponse.body()
            ?.map { Character(it.id, it.name, it.voiceActor, it.species) }
            ?: return dbCharacters

        dbCharacters.forEach { dbCharacter ->
            val character = characters.find { it.id == dbCharacter.id }

            when {
                character == null -> charactersDao.delete(dbCharacter)
                character != dbCharacter -> charactersDao.update(character)
            }
        }

        characters.forEach {
            if (dbCharacters.none { dbCharacter -> it.id == dbCharacter.id })
                charactersDao.create(it)
        }

        return characters
    }

    private suspend fun <T> callApiOrIgnoreError(fn: suspend () -> Response<T>): Response<T> =
        runCatching {
            fn()
        }.getOrElse {
            Log.e("api", "Service unavailable: $it")
            Response.error(503, "Service unavailable".toResponseBody())
        }

}