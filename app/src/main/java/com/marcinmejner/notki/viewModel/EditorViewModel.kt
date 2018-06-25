package com.marcinmejner.notki.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.marcinmejner.notki.database.AppRepository
import com.marcinmejner.notki.database.NoteEntity
import java.util.concurrent.Executors

class EditorViewModel(application: Application) : AndroidViewModel(application) {
    val liveNote: MutableLiveData<NoteEntity> = MutableLiveData()

    val repository: AppRepository
    val executor = Executors.newSingleThreadExecutor()

    init {
        repository = AppRepository.getInstance(getApplication())
    }

    fun loadData(noteId: Int) {
        executor.execute {
            val note = repository.getNoteById(noteId)
            liveNote.postValue(note)
        }
    }
}