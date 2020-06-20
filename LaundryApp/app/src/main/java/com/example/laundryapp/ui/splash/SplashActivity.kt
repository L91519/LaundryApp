package com.example.laundryapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.laundryapp.R
import com.example.laundryapp.ui.auth.SignInActivity

class SplashActivity: AppCompatActivity() {
//    private val SPLASH_TIME: Long = 1500
    private val SPLASH_TIME: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }, SPLASH_TIME)
    }
}