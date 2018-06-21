package com.marcinmejner.notki.database

import com.marcinmejner.notki.utils.SampleData

object AppRepository {

    val notes: List<NoteEntity> = SampleData.getNotes()

}