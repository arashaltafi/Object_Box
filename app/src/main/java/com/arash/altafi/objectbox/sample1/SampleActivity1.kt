package com.arash.altafi.objectbox.sample1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.arash.altafi.objectbox.databinding.ActivitySample1Binding

class SampleActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivitySample1Binding
    private val userBox by lazy { ObjectBox.getBox<User>() }
//    private val userBox = ObjectBox.store.boxFor(User::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySample1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            btnPut.setOnClickListener {
                val userPut = User(name = "Arash")
                userBox.put(userPut)
                Log.i("test123321", "userPut = $userPut")
            }

            btnGet.setOnClickListener {
                val userGet1 = userBox[1]
                Log.i("test123321", "userGet1 = $userGet1")

                //OR
                val query = userBox.query().equal(User_.id, 1).build()
                val userGet2 = query.findFirst()
                query.close()
                Log.i("test123321", "userGet2 = $userGet2")
            }

            btnGetAbove.setOnClickListener {
                //Get Field id equal 10 Or Above 10
                val query = userBox.query().greater(User_.id, 10).or().equal(User_.id, 10).build()
                val userGetAbove = query.find().size
                query.close()
                Log.i("test123321", "userGetAbove Size = $userGetAbove")
            }

            btnGetAll.setOnClickListener {
                val userGetAll = userBox.all
                Log.i("test123321", "userGetAll = $userGetAll")
            }

            btnRemove.setOnClickListener {
                val userRemove = userBox.remove(1)
                Log.i("test123321", "userRemove = $userRemove")
            }

            btnRemoveUnder.setOnClickListener {
                //Remove Field id equal 10 Or Under 10
                val query = userBox.query().less(User_.id, 10).or().equal(User_.id, 10).build()
                val userRemoveUnder = query.remove()
                query.close()
                Log.i("test123321", "userRemoveUnder = $userRemoveUnder")
            }

            btnRemoveAll.setOnClickListener {
                userBox.removeAll()
                Log.i("test123321", "RemoveAll")
            }
        }
    }
}