package com.example.realchat.view

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.realchat.databinding.ActivityLoginBinding
import com.example.realchat.view.util.LoginModule
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

//    lateinit var mAuth: FirebaseAuth

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        mAuth = Firebase.auth

        binding.loginBtn.setOnClickListener {

            val email = binding.emailEdit.text.toString()
            val password = binding.passwordEdit.text.toString()

            LoginModule.signIn(email, password, this)

//            login(email, password)
        }

        binding.signUpBtn.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

    }

    // 모듈로 빼놨음
//    @RequiresApi(Build.VERSION_CODES.O)
//    private fun login(email: String, password: String) {
//        mAuth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
//                    startActivity(intent)
//                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
//                    finish()
//                } else {
//                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
//                    Log.d("Login", "Error: ${task.exception}")
//                }
//            }
//    }

}