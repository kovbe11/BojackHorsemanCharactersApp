package hu.bme.aut.android.bojackhorseman

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.Gson
import dagger.hilt.android.testing.HiltAndroidTest
import hu.bme.aut.android.bojackhorseman.network.CharacterDTO
import hu.bme.aut.android.bojackhorseman.network.CharactersApi
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class CharactersApiTest {

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private val api = retrofit.create(CharactersApi::class.java)

    companion object {
        @JvmField
        val mockWebServer = MockWebServer()

        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            mockWebServer.start()
        }

        @AfterClass
        @JvmStatic
        fun tearDownClass() {
            mockWebServer.shutdown()
        }
    }

    @Test
    fun testCreate() = runBlocking {
        val character = CharacterDTO(1, "Test", "Test Voice Actor", "Test Species")
        mockWebServer.enqueue(MockResponse().setBody("{}"))

        val actual = api.create(character)

        assertTrue(actual.isSuccessful)
    }

    @Test
    fun testFindAll() = runBlocking {
        val characters = listOf(CharacterDTO(1, "Test", "Test Voice Actor", "Test Species"))
        val response = Response.success(characters)
        mockWebServer.enqueue(MockResponse().setBody(Gson().toJson(characters)))

        val actual = api.findAll()

        assertNotNull(actual.body())
        assertEquals(response.body(), actual.body())
    }

    @Test
    fun testUpdate() = runBlocking {
        val character = CharacterDTO(1, "Test", "Test Voice Actor", "Test Species")
        mockWebServer.enqueue(MockResponse().setBody("{}"))

        val actual = api.update(character)

        assertTrue(actual.isSuccessful)
    }

    @Test
    fun testDelete() = runBlocking {
        mockWebServer.enqueue(MockResponse().setBody("{}"))

        val actual = api.delete(1)

        assertTrue(actual.isSuccessful)
    }

}