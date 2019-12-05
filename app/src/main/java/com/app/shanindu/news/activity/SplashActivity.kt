package com.app.shanindu.news.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.app.shanindu.news.R


class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 1200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        val manager = this.packageManager
        val info = manager.getPackageInfo(this.packageName, PackageManager.GET_ACTIVITIES)
        Toast.makeText("PackageName = " + info.packageName + "\nVersionCode = "
                + info.versionCode + "\nVersionName = "
                + info.versionName + "\nPermissions = " + info.permissions)

        Handler().postDelayed(Runnable {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, SPLASH_TIME_OUT)


    }
}
