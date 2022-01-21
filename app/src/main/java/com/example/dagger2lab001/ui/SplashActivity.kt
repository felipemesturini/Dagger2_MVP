package com.example.dagger2lab001.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.dagger2lab001.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(mainLooper).postDelayed( {
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }, 4000)
    }
}