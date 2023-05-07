package hu.bme.aut.android.bojackhorseman

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import hu.bme.aut.android.bojackhorseman.persistence.AppDatabase
import org.junit.After
import org.junit.Before

abstract class InMemoryDb {

    lateinit var db: AppDatabase

    @Before
    fun initDB() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun closeDB() {
        db.close()
    }
}
