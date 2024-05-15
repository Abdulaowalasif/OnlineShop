package com.example.onlineshop.activities.SignIn

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.onlineshop.R
import com.example.onlineshop.activities.signup.SignUp
import com.example.onlineshop.databinding.ActivitySignInBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class SignIN : AppCompatActivity() {
    private val binding: ActivitySignInBinding by lazy {
        ActivitySignInBinding.inflate(layoutInflater)
    }

    lateinit var signInViewModel: SignInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        signInViewModel =
            ViewModelProvider(this, SignInViewModelFactory(this))[SignInViewModel::class.java]

        binding.loginBtn.setOnClickListener {
            val email = binding.email.text.toString()
            val pass = binding.password.text.toString()
            signInViewModel.login(email, pass)


        }

        binding.signupText.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }


    }
}