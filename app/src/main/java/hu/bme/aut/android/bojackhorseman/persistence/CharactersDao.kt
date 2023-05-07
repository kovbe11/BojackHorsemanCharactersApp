package hu.bme.aut.android.bojackhorseman.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import hu.bme.aut.android.bojackhorseman.model.Character

@Dao
interface CharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(character: Character)

    @Query("SELECT * FROM characters")
    suspend fun findAll(): List<Character>

    @Update
    suspend fun update(character: Character)

    @Delete
    suspend fun delete(character: Character)
}