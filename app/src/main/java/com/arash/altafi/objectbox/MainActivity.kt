package com.arash.altafi.objectbox

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnPut: MaterialButton
    private lateinit var btnRemove: MaterialButton
    private lateinit var btnRemoveAll: MaterialButton
    private lateinit var btnGet: MaterialButton
    private lateinit var btnGetAll: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPut = findViewById(R.id.btn_put)
        btnGet = findViewById(R.id.btn_get)
        btnGetAll = findViewById(R.id.btn_get_all)
        btnRemove = findViewById(R.id.btn_remove)
        btnRemoveAll = findViewById(R.id.btn_remove_all)

        val userBox = ObjectBox.store.boxFor(User::class.java)

        btnPut.setOnClickListener {
            val userPut = User(name = "Arash")
            userBox.put(userPut)
            Log.i("test123321", "userPut = $userPut")
        }

        btnGet.setOnClickListener {
            val userGet = userBox[1]
            Log.i("test123321", "userGet = $userGet")
        }

        btnGetAll.setOnClickListener {
            val userGetAll = userBox.all
            Log.i("test123321", "userGetAll = $userGetAll")
        }

        btnRemove.setOnClickListener {
            val userRemove = userBox.remove(1)
            Log.i("test123321", "userRemove = $userRemove")
        }

        btnRemoveAll.setOnClickListener {
            userBox.removeAll()
            Log.i("test123321", "RemoveAll")
        }

    }
}