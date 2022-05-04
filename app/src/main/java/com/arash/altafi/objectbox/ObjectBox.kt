package com.arash.altafi.objectbox

import android.content.Context

object ObjectBox : ObjectBoxContract() {

    override fun init(context: Context) {
        store = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .build()
    }
}