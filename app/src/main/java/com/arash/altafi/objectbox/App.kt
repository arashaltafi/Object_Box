package com.arash.altafi.objectbox

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        com.arash.altafi.objectbox.sample2.database.ObjectBox.init(this)
        com.arash.altafi.objectbox.sample1.ObjectBox.init(this)
    }

}