package com.example.realchat.view.util

import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.realchat.view.LoginActivity
import com.example.realchat.view.MainActivity
import com.example.realchat.view.SignUpActivity
import com.example.realchat.view.model.User
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object LoginModule {

    val mAuth = Firebase.auth
    val mDbRef = Firebase.database.reference

    @RequiresApi(Build.VERSION_CODES.O)
    fun signIn(
        email: String,
        password: String,
        activity: LoginActivity
    ) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(activity, MainActivity::class.java)
                    activity.startActivity(intent)
                    Toast.makeText(activity, "로그인 성공", Toast.LENGTH_SHORT).show()
                    activity.finish()
                } else {
                    Toast.makeText(activity, "로그인 실패", Toast.LENGTH_SHORT).show()
                    Log.d("Login", "Error: ${task.exception}")
                }
            }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun signUp(
        name: String,
        email: String,
        password: String,
        activity: SignUpActivity
    ) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if(task.isSuccessful) {
                    Toast.makeText(activity, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(activity, MainActivity::class.java)
                    activity.startActivity(intent)
                    addUserToDatabase(name, email, mAuth.currentUser?.uid!!)
                } else {
                    Toast.makeText(activity, "회원가입 실패", Toast.LENGTH_SHORT).show()
                    Log.d("SignUp", "Error: ${task.exception}")
                }
            }
    }

    private fun addUserToDatabase(name: String, email: String, uid: String) {
        mDbRef.child("user").child(uid).setValue(User(name, email, uid))
    }


}