package com.dicoding.picodiploma.kucingkucing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class about : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionbar = supportActionBar
        actionbar!!.title = "About"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgMe: ImageView = findViewById(R.id.img_item_photo)

        val tImg = "https://d17ivq9b7rppb3.cloudfront.net/small/avatar/2020051113152366ba4a97369c4a6fee633c6f76f301e8.png"

        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgMe)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}