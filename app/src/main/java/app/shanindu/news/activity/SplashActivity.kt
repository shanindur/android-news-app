package com.shanindu.app.news.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.app.shanindu.news.R
import com.app.shanindu.news.activity.MainActivity


class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 1200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide();

        Handler().postDelayed(Runnable {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, SPLASH_TIME_OUT)


    }
}
