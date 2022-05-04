package com.arash.altafi.objectbox

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private val userBox by lazy { ObjectBox.getBox<User>() }
//    private val userBox = ObjectBox.store.boxFor(User::class.java)
    private lateinit var btnPut: MaterialButton
    private lateinit var btnRemove: MaterialButton
    private lateinit var btnRemoveUnder: MaterialButton
    private lateinit var btnRemoveAll: MaterialButton
    private lateinit var btnGet: MaterialButton
    private lateinit var btnGetAbove: MaterialButton
    private lateinit var btnGetAll: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPut = findViewById(R.id.btn_put)
        btnGet = findViewById(R.id.btn_get)
        btnGetAbove = findViewById(R.id.btn_get_above)
        btnGetAll = findViewById(R.id.btn_get_all)
        btnRemove = findViewById(R.id.btn_remove)
        btnRemoveUnder = findViewById(R.id.btn_remove_under)
        btnRemoveAll = findViewById(R.id.btn_remove_all)

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