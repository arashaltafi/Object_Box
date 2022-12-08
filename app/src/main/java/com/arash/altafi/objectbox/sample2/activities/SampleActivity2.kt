package com.arash.altafi.objectbox.sample2.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arash.altafi.objectbox.databinding.ActivitySample2Binding
import com.arash.altafi.objectbox.sample2.adapter.UserAdapter
import com.arash.altafi.objectbox.sample2.model.User2
import com.arash.altafi.objectbox.sample2.viewModel.UserViewModel

class SampleActivity2 : AppCompatActivity(), UserAdapter.UserAdapterInterface {

    private lateinit var binding: ActivitySample2Binding
    private lateinit var userAdapter: UserAdapter
    private var userList = ArrayList<User2>()

    private val userViewModel by lazy { ViewModelProvider(this)[UserViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySample2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()

        binding.createBtn.setOnClickListener {
            startActivity(Intent(this, AddUserActivity::class.java))
        }

        userViewModel.getAllUser().observe(this) {
            userAdapter.addUserData(it as ArrayList<User2>)
        }

    }

    private fun setUpUI() {
        userAdapter = UserAdapter(this, userList, this)

        binding.dataRecyclerView.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@SampleActivity2)
            setHasFixedSize(true)
            recycledViewPool.setMaxRecycledViews(1, 0)
        }
    }

    override fun delete(item: User2) {
        userViewModel.delete(item)
    }

    override fun update(item: User2) {
        val intent = Intent(this, AddUserActivity::class.java).apply {
            putExtra("id", item.id.toString())
            putExtra("userName", item.userName)
            putExtra("email", item.userEmail)
        }
        startActivity(intent)

    }
}