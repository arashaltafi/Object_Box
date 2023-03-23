package com.arash.altafi.objectbox.sample1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.arash.altafi.objectbox.databinding.ActivitySample1Binding

class SampleActivity1 : AppCompatActivity() {

    private val binding by lazy {
        ActivitySample1Binding.inflate(layoutInflater)
    }

    private val userBox by lazy { ObjectBox.getBox<User>() }
//    private val userBox = ObjectBox.store.boxFor(User::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        btnPut.setOnClickListener {
            val userPut = User(username = "Arash")
            userBox.put(userPut)
            Log.i(TAG, "userPut = $userPut")
            scrollUpAndChangeTextView("userPut = $userPut")
        }

        btnGet.setOnClickListener {
            val userGet1 = userBox[1]
            Log.i(TAG, "userGet1 = $userGet1")

            //OR
            val query = userBox.query().equal(User_.id, 1).build()
            val userGet2 = query.findFirst()
            query.close()
            Log.i(TAG, "userGet2 = $userGet2")
            scrollUpAndChangeTextView("userGet2 = $userGet2")
        }

        btnGetAbove.setOnClickListener {
            //Get Field id equal 10 Or Above 10
            val query = userBox.query().greater(User_.id, 10).or().equal(User_.id, 10).build()
            val userGetAbove = query.find().size
            query.close()
            Log.i(TAG, "userGetAbove Size = $userGetAbove")
            scrollUpAndChangeTextView("userGetAbove Size = $userGetAbove")
        }

        btnGetAll.setOnClickListener {
            val userGetAll = userBox.all
            Log.i(TAG, "userGetAll = $userGetAll")
            scrollUpAndChangeTextView("userGetAll = $userGetAll")
        }

        btnRemove.setOnClickListener {
            val userRemove = userBox.remove(1)
            Log.i(TAG, "userRemove = $userRemove")
            scrollUpAndChangeTextView("userRemove = $userRemove")
        }

        btnRemoveUnder.setOnClickListener {
            //Remove Field id equal 10 Or Under 10
            val query = userBox.query().less(User_.id, 10).or().equal(User_.id, 10).build()
            val userRemoveUnder = query.remove()
            query.close()
            Log.i(TAG, "userRemoveUnder = $userRemoveUnder")
            scrollUpAndChangeTextView("userRemoveUnder = $userRemoveUnder")
        }

        btnRemoveAll.setOnClickListener {
            userBox.removeAll()
            Log.i(TAG, "RemoveAll")
            scrollUpAndChangeTextView("RemoveAll")
        }
    }

    private fun scrollUpAndChangeTextView(text: String) = binding.apply {
        nestedScrollView.scrollTo(0, 0)
        tvData.text = text
    }

    companion object {
        private const val TAG = "SampleActivity1"
    }

}