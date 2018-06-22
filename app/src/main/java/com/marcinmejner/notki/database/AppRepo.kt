package com.marcinmejner.notki.database

import android.content.Context

class AppRepo private constructor(context: Context) {
    companion object {
        private var ourInstance: AppRepo? = null

        fun getInstance(context: Context): AppRepo {
            if (ourInstance == null) {
                ourInstance = AppRepo(context)
            }
            return ourInstance!!
        }
    }
}
