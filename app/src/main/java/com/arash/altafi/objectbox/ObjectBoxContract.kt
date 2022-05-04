package com.arash.altafi.objectbox

import android.content.Context
import io.objectbox.Box
import io.objectbox.BoxStore

abstract class ObjectBoxContract {
    lateinit var store: BoxStore

    abstract fun init(context: Context)

    inline fun <reified T> getBox(): Box<T> {
        return store.boxFor(T::class.java)
    }
}