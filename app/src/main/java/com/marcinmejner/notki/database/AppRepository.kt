package com.marcinmejner.notki.database

import android.arch.lifecycle.LiveData
import android.content.Context
import android.util.Log
import com.marcinmejner.notki.utils.SampleData
import java.util.concurrent.Executor
import java.util.concurrent.Executors


class AppRepository private constructor(context: Context) {
    private val TAG = "AppRepository"

    var notes: LiveData<List<NoteEntity>>
    var db: AppDatabase
    val executor: Executor = Executors.newSingleThreadExecutor()

    init {
        Log.d(TAG, "AppRepository started: ")
        db = AppDatabase.getInstance(context)
        notes = getAllNotes()
    }

    companion object {
        private var ourInstance: AppRepository? = null

        fun getInstance(context: Context): AppRepository {
            if (ourInstance == null) {
                ourInstance = AppRepository(context)
            }
            return ourInstance!!
        }
    }

    fun addSampleData() {
        executor.execute {
            db.noteDao().insertAll(SampleData.getNotes())
        }
    }

    fun deleteAllNotes() {
        executor.execute {
            db.noteDao().deleteAll()
        }
    }

    fun getAllNotes(): LiveData<List<NoteEntity>> {
        return db.noteDao().getall()
    }

    fun getNoteById(noteId: Int): NoteEntity? {
        return db.noteDao().getNoteById(noteId)
    }
}