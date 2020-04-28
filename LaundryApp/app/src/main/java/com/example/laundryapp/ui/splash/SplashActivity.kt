package com.example.laundryapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.laundryapp.R
import com.example.laundryapp.ui.laundry_list.LaundryListActivity

class SplashActivity: AppCompatActivity() {
    val SPLASH_TIME: Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, LaundryListActivity::class.java))
            finish()
        }, SPLASH_TIME)
    }
}