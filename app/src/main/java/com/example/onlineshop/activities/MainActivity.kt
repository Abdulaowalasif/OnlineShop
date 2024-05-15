package com.example.onlineshop.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.activities.SignIn.SignIN
import com.example.onlineshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getStartedBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }

        binding.signIn.setOnClickListener{
            startActivity(Intent(this, SignIN::class.java))
        }
    }
}