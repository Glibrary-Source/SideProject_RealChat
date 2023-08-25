package com.example.realchat.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.realchat.view.model.User
import com.example.realchat.databinding.ActivitySignUpBinding
import com.example.realchat.view.util.LoginModule
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding

    lateinit var mAuth: FirebaseAuth

    private lateinit var mDbRef: DatabaseReference

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //firebase 인증초기화
//        mAuth = Firebase.auth

        //db 초기화
//        mDbRef = Firebase.database.reference


        binding.signUpBtn.setOnClickListener {

            val name = binding.nameEdit.text.toString().trim()
            val email = binding.emailEdit.text.toString().trim()
            val password = binding.passwordEdit.text.toString().trim()

            LoginModule.signUp(name, email, password, this)

//            signUp(name, email, password)
        }

    }

//    @RequiresApi(Build.VERSION_CODES.O)
//    private fun signUp(name: String, email: String, password: String) {
//
//        mAuth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this) { task ->
//                if(task.isSuccessful) {
//                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this@SignUpActivity, MainActivity::class.java)
//                    startActivity(intent)
//                    addUserToDatabase(name, email, mAuth.currentUser?.uid!!)
//                } else {
//                    Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
//                    Log.d("SignUp", "Error: ${task.exception}")
//                }
//            }
//    }
//
//    private fun addUserToDatabase(name: String, email: String, uid: String) {
//        mDbRef.child("user").child(uid).setValue(User(name, email, uid))
//    }

}