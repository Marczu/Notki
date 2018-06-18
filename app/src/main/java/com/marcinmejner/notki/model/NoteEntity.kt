package com.marcinmejner.notki.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "notes")
data class NoteEntity(
        @PrimaryKey(autoGenerate = true)
        var date: Date? = null,
        var noteText:String = "",
        var id:Int = 0
)

