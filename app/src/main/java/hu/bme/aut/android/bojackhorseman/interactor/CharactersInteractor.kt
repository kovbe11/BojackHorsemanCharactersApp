package hu.bme.aut.android.bojackhorseman.interactor

import hu.bme.aut.android.bojackhorseman.model.Character
import hu.bme.aut.android.bojackhorseman.persistence.CharactersDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharactersInteractor @Inject constructor(
    private val charactersDao: CharactersDao
//    private val charactersApi: CharactersApi
) {

    suspend fun createCharacter(character: Character) = withContext(Dispatchers.IO) {
        charactersDao.create(character)
        // or charactersApi.create(character)
    }

    suspend fun getCharacters(): List<Character> = withContext(Dispatchers.IO) {
        charactersDao.findAll()
        // or charactersApi.findAll()
    }

    suspend fun updateCharacter(character: Character) = withContext(Dispatchers.IO) {
        charactersDao.update(character)
        // or charactersApi.update(character)
    }

    suspend fun deleteCharacter(character: Character) = withContext(Dispatchers.IO) {
        charactersDao.delete(character)
        // or charactersApi.delete(character)
    }


}