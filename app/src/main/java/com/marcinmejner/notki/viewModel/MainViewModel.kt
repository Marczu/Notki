package com.marcinmejner.notki.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.marcinmejner.notki.database.AppRepository
import com.marcinmejner.notki.database.NoteEntity
import com.marcinmejner.notki.utils.SampleData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG = "MainViewModel"

    var repository: AppRepository = AppRepository
    var notes: List<NoteEntity>

    init {
        notes = repository.notes
    }



}