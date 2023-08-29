package com.example.realchat.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realchat.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        CoroutineScope(Main).launch {
            delay(3000)
            val intent = Intent(this@SplashActivity, LoginActivity::class.java )
            startActivity(intent)
            finish()
        }
    }
}