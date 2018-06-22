package com.marcinmejner.notki.database

import android.content.Context
import com.marcinmejner.notki.utils.SampleData


class AppRepository private constructor(context: Context) {
    private val TAG = "AppRepository"

    val notes: List<NoteEntity> = SampleData.getNotes()

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

    }
}