package hu.bme.aut.android.bojackhorseman.persistence

import android.util.Log
import hu.bme.aut.android.bojackhorseman.model.Character

//@Database(entities = [Character::class], exportSchema = false)
class AppDatabase {
    fun charactersDao(): CharactersDao = object : CharactersDao {
        override suspend fun create(character: Character) {
            Log.i("debug", "create called")
            //mock
        }

        override suspend fun findAll(): List<Character> {
            Log.i("debug", "findall called")
            val list = mutableListOf<Character>()
            for (position in 1..20) {
                list.add(
                    Character(
                        position,
                        "Name $position",
                        "Voice actor $position",
                        "Some species"
                    )
                )
            }
            Log.i("debug", "$list returned")
            return list
        }

        override suspend fun update(character: Character) {
            Log.i("debug", "update called with $character")
        }

        override suspend fun delete(character: Character) {
            Log.i("debug", "delete called with $character")
        }

    }
}