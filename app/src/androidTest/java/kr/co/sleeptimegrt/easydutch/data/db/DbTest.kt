package kr.co.sleeptimegrt.easydutch.data.db

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import org.junit.After
import org.junit.Before

/**
 * Created by minchulkim on 2018-03-04.
 */
abstract class DbTest {

    lateinit var db: NBreadDatabase

    @Before
    fun initDB() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                NBreadDatabase::class.java).allowMainThreadQueries().build()
    }

    @After
    fun closeDB() {
        db.close()
    }
}