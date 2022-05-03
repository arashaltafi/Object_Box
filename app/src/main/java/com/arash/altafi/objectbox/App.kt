package com.arash.altafi.objectbox

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
    }

}