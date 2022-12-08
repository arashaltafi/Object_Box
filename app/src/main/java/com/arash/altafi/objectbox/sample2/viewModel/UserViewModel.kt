package com.arash.altafi.objectbox.sample2.viewModel

import androidx.lifecycle.ViewModel
import com.arash.altafi.objectbox.sample2.model.User2_
import com.arash.altafi.objectbox.sample2.database.ObjectBox
import com.arash.altafi.objectbox.sample2.model.User2
import io.objectbox.android.ObjectBoxLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel : ViewModel() {

    private val coroutineContext: CoroutineContext get() = Dispatchers.Main

    fun insert(data: User2) = CoroutineScope(coroutineContext).launch(Dispatchers.IO) {
        ObjectBox.boxStore.boxFor(User2::class.java).put(data)
    }

    fun delete(data: User2) = CoroutineScope(coroutineContext).launch(Dispatchers.IO) {
        val userBox = ObjectBox.boxStore.boxFor(User2::class.java)
        userBox.remove(data)
    }

    fun update(data: User2) = CoroutineScope(coroutineContext).launch(Dispatchers.IO) {
        ObjectBox.boxStore.boxFor(User2::class.java).put(data)
    }

    fun getAllUser(): ObjectBoxLiveData<User2> {
        val usersQuery = ObjectBox.boxStore.boxFor(User2::class.java).query()
            .orderDesc(User2_.id)
            .build()
        return ObjectBoxLiveData(usersQuery)
    }

    fun deleteAll() {
        ObjectBox.boxStore.boxFor(User2::class.java).removeAll()
    }
}