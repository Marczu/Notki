package com.marcinmejner.notki.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "notes")
data class NoteEntity(
        var date: Date? = null,
        var noteText:String = "",
        @PrimaryKey(autoGenerate = true) var id:Int = 0
)

