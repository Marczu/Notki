package com.marcinmejner.notki.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.util.Log
import com.marcinmejner.notki.database.AppRepository
import com.marcinmejner.notki.database.NoteEntity
import com.marcinmejner.notki.utils.SampleData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG = "MainViewModel"

    var repository: AppRepository = AppRepository.getInstance(application.applicationContext)
    var notes: LiveData<List<NoteEntity>>

    init {
        notes = repository.notes
        Log.d(TAG, "MainViewModel started: ")
    }

    fun addSampleData() {
        repository.addSampleData()
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

}
