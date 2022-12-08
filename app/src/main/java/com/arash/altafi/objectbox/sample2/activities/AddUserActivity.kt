package com.arash.altafi.objectbox.sample2.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.arash.altafi.objectbox.databinding.ActivityAddUserBinding
import com.arash.altafi.objectbox.sample2.model.User2
import com.arash.altafi.objectbox.sample2.viewModel.UserViewModel

class AddUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddUserBinding

    private val userViewModel by lazy { ViewModelProvider(this)[UserViewModel::class.java] }

    private var edit = false
    private var id: Long = 0
    private var name = ""
    private var email = ""

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar!!.title = "Add User"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if (intent.hasExtra("id")) {

            supportActionBar!!.title = "Update User"

            edit = true
            id = intent.getStringExtra("id")!!.toLong()
            name = intent.getStringExtra("userName")!!
            email = intent.getStringExtra("email")!!
            setUpUI()
        }

        binding.buttonSave.setOnClickListener {
            binding.buttonSave.isEnabled = false
            val name = binding.userName.editText!!.text.toString()
            val email = binding.email.editText!!.text.toString()
            if (isValidate()) {

                if (edit) {
                    User2(userName = name, userEmail = email, id = id)
                    userViewModel.update(User2(userName = name, userEmail = email, id = id))
                } else {
                    userViewModel.insert(User2(userName = name, userEmail = email))
                }

                finish()
            }
        }
    }

    private fun setUpUI() {
        binding.editName.setText(name)
        binding.editEmail.setText(email)
    }

    private fun isValidate(): Boolean {
        return when {
            binding.userName.editText!!.text.toString().isEmpty() -> {
                binding.userName.error = "User Name must not be empty"
                binding.buttonSave.isEnabled = true
                false
            }
            binding.email.editText!!.text.toString().isEmpty() -> {
                binding.email.error = "Email must not be empty"
                binding.buttonSave.isEnabled = true
                false
            }
            else -> true
        }
    }
}