package hu.bme.aut.android.bojackhorseman.persistence

import hu.bme.aut.android.bojackhorseman.model.Character

//@Database(entities = [Character::class], exportSchema = false)
class AppDatabase {
    fun charactersDao(): CharactersDao = object : CharactersDao {
        override suspend fun create(character: Character) {
            //mock
        }

        override suspend fun findAll(): List<Character> {
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
            return list
        }

        override suspend fun update(character: Character) {
            //mock
        }

        override suspend fun delete(character: Character) {
            //mock
        }

    }
}