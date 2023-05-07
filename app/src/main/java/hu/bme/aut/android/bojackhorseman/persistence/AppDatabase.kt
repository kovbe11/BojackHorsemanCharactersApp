package hu.bme.aut.android.bojackhorseman.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.bme.aut.android.bojackhorseman.model.Character

@Database(entities = [Character::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun charactersDao(): CharactersDao
}