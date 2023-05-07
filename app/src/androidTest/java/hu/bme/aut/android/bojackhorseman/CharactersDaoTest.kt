package hu.bme.aut.android.bojackhorseman

import androidx.test.ext.junit.runners.AndroidJUnit4
import hu.bme.aut.android.bojackhorseman.model.Character
import hu.bme.aut.android.bojackhorseman.persistence.CharactersDao
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CharactersDaoTest : InMemoryDb() {


    private lateinit var dao: CharactersDao

    @Before
    fun setup() {
        dao = db.charactersDao()
    }


    @Test
    fun testCreateAndFindAll() = runBlocking {
        val character = Character(1, "Test", "Test Voice Actor", "Test Species")
        dao.create(character)
        val characters = dao.findAll()
        assertEquals(1, characters.size)
        assertEquals(character, characters[0])
    }

    @Test
    fun testUpdate() = runBlocking {
        val character = Character(1, "Test", "Test Voice Actor", "Test Species")
        dao.create(character)
        val updatedCharacter =
            Character(1, "Updated Test", "Updated Test Voice Actor", "Updated Test Species")
        dao.update(updatedCharacter)
        val characters = dao.findAll()
        assertEquals(1, characters.size)
        assertEquals(updatedCharacter, characters[0])
    }

    @Test
    fun testDelete() = runBlocking {
        val character = Character(1, "Test", "Test Voice Actor", "Test Species")
        dao.create(character)
        dao.delete(character)
        val characters = dao.findAll()
        assertTrue(characters.isEmpty())
    }
}