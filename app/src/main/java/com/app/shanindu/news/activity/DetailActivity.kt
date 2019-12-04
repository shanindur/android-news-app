package com.app.shanindu.news.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.app.shanindu.news.R

class DetailActivity : AppCompatActivity() {

    private var imgNews: ImageView? = null
    private var txtDescription: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Detail Activity"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        initComponent()
    }

    private fun initComponent() {

        imgNews = findViewById<ImageView>(R.id.btn_retry)
        txtDescription = findViewById<TextView>(R.id.txt_description)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
