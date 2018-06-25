package com.marcinmejner.notki.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.marcinmejner.notki.database.AppRepository
import com.marcinmejner.notki.database.NoteEntity

class EditorViewModel(application: Application) : AndroidViewModel(application) {

    val liveNote: MutableLiveData<NoteEntity> = MutableLiveData()
    val repository: AppRepository

    init {
        repository = AppRepository.getInstance(getApplication())
    }
}