package com.example.realchat.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realchat.databinding.ActivitySignUpBinding
import com.example.realchat.view.util.LoginModule

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpBtn.setOnClickListener {
            val name = binding.nameEdit.text.toString().trim()
            val email = binding.emailEdit.text.toString().trim()
            val password = binding.passwordEdit.text.toString().trim()

            LoginModule.signUp(name, email, password, this)
        }
    }

}