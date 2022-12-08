package com.arash.altafi.objectbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.arash.altafi.objectbox.databinding.ActivityMainBinding
import com.arash.altafi.objectbox.sample1.SampleActivity1
import com.arash.altafi.objectbox.sample2.activities.SampleActivity2

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        btnSample1.setOnClickListener {
            startActivity(Intent(this@MainActivity, SampleActivity1::class.java))
        }

        btnSample2.setOnClickListener {
            startActivity(Intent(this@MainActivity, SampleActivity2::class.java))
        }
    }

}