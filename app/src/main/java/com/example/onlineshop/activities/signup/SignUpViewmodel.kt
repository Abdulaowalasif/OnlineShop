package com.example.onlineshop.activities.signup

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

class SignUpViewmodel (  val context: Context) : ViewModel() {

    private val auth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance()

    fun createUser(email: String, pass: String, name: String) {
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
            if (it.isSuccessful) {
                database.getReference(Constant.USER).child(auth.uid!!)
                    .setValue(UserModel(name, email))
                    .addOnCompleteListener {
                        context.startActivity(Intent(context, MainActivity2::class.java))
                    }
            }
        }
    }
}