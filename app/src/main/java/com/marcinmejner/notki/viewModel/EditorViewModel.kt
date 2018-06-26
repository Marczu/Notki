package com.marcinmejner.notki.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.text.TextUtils
import android.widget.Toast
import com.marcinmejner.notki.database.AppRepository
import com.marcinmejner.notki.database.NoteEntity
import java.util.*
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

    fun saveNote(noteTxt: String) {
        var note = liveNote.value

        if (note == null) {
            if (TextUtils.isEmpty(noteTxt.trim())) {
                Toast.makeText(getApplication(), "Notka nie moze być pusta", Toast.LENGTH_LONG).show()
                return
            }
            note = NoteEntity(Date(), noteTxt.trim())

        } else {
            note.noteText = noteTxt.trim()
        }

        repository.insertNote(note)

    }
}