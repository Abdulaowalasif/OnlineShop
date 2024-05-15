package com.example.onlineshop.activities.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.onlineshop.databinding.ActivitySignUpBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUp : AppCompatActivity() {

    val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    lateinit var signUpViewmodel: SignUpViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        signUpViewmodel =
            ViewModelProvider(this, SIgnUpViewModelFactory(this))[SignUpViewmodel::class.java]

        binding.createAccount.setOnClickListener {
            val name = binding.registerName.text.toString()
            val email = binding.registerEmail.text.toString()
            val pass = binding.registerPassword.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                signUpViewmodel.createUser(email, pass, name)
            }

        }

    }
}