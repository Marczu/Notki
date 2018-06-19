package com.marcinmejner.notki.database

import android.arch.persistence.room.TypeConverter
import java.util.*

class DateConverter {

    companion object {

        @TypeConverter
        fun toDate(timestamp: Long): Date?{

            return Date(timestamp)
        }

        @TypeConverter
        fun toTimeStamp(date: Date?): Long? {
            return date?.time
        }

    }

}

