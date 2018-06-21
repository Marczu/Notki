package com.marcinmejner.notki

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.marcinmejner.notki.database.AppDatabase
import com.marcinmejner.notki.database.NoteDao
import com.marcinmejner.notki.database.NoteEntity
import com.marcinmejner.notki.utils.SampleData
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class DataBaseTest {
    private val TAG = "DataBaseTest"

    lateinit var db: AppDatabase
    var dao: NoteDao? = null

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.noteDao()
        Log.d(TAG, "createDb: created database")
    }

    @After
    fun closeDb() {
        db.close()
        Log.d(TAG, "closeDb: databse closed")
    }

    @Test
    fun createAndRetriveNotes() {
        dao?.insertAll(SampleData.getNotes())
        var count = dao?.getCount()
        Log.d(TAG, "createAndRetriveNotes: count $count")

        assertEquals(SampleData.getNotes().size, count)
    }

    @Test
    fun compareStrings() {
        dao?.insertAll(SampleData.getNotes())
        val original: NoteEntity = SampleData.getNotes()[0]
        val fromDb: NoteEntity = dao?.getNoteById(1)!!

        assertEquals(original.noteText, fromDb.noteText)
        assertEquals(1, fromDb.id)
    }

}