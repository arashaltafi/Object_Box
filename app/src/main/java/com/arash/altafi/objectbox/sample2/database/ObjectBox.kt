package com.arash.altafi.objectbox.sample2.database

import android.content.Context
import com.arash.altafi.objectbox.MyObjectBox
import io.objectbox.BoxStore

object ObjectBox {

    lateinit var boxStore: BoxStore
        private set

    fun init(context: Context) {
        boxStore = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .name("sample2")
            .build()
    }

}