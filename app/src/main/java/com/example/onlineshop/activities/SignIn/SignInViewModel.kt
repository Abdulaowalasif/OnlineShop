package com.example.onlineshop.activities.SignIn

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.onlineshop.Constant
import com.example.onlineshop.activities.MainActivity2
import com.example.onlineshop.models.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SignInViewModel(val context: Context) : ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    fun login(email: String, pass: String) {
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
            if (it.isSuccessful) {
                context.startActivity(Intent(context, MainActivity2::class.java))
            }
        }
    }


}