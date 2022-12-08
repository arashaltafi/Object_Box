package com.arash.altafi.objectbox.sample1

import android.content.Context
import com.arash.altafi.objectbox.MyObjectBox

object ObjectBox : ObjectBoxContract() {

    override fun init(context: Context) {
        store = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .name("sample1")
            .build()
    }
}