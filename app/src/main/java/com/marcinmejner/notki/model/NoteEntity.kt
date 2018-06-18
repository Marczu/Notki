package com.marcinmejner.notki.model

import java.util.*

data class NoteEntity(
        var date: Date? = null,
        var noteText:String = "",
        var id:Int = 0
)

