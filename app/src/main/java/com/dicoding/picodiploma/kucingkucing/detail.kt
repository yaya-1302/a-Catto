package com.dicoding.picodiploma.kucingkucing


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class detail: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        val actionBar = supportActionBar
        actionBar!!.title = "Detail"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_set_nama)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetChar: TextView = findViewById(R.id.tv_set_karakter)
        val tvSetAsal: TextView = findViewById(R.id.tv_set_asal)
        val tvHabit: TextView = findViewById(R.id.tv_set_habit)
        val tvTnT: TextView = findViewById(R.id.tv_set_TnT)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tImg = intent.getStringExtra(EXTRA_PHOTO)
        val tChar = intent.getStringExtra(EXTRA_CHAR)
        val tAsal = intent.getStringExtra(EXTRA_ASAL)
        val tHabit = intent.getStringExtra(EXTRA_HABIT)
        val tTnt = intent.getStringExtra(EXTRA_TNT)

        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetChar.text = tChar
        tvSetAsal.text = tAsal
        tvHabit.text = tHabit
        tvTnT.text = tTnt
    }
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_CHAR = "extra_karakter"
        const val EXTRA_ASAL = "extra_asalUsul"
        const val EXTRA_HABIT = "extra_habit"
        const val EXTRA_TNT = "extra_tips"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}