package com.dicoding.picodiploma.kucingkucing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.kucingkucing.adapter.ListCatAdapter
import com.dicoding.picodiploma.kucingkucing.model.DataKucing
import com.dicoding.picodiploma.kucingkucing.model.Kucing


class MainActivity : AppCompatActivity() {
    private lateinit var rvCat: RecyclerView
    private var list: ArrayList<Kucing> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Home"

        rvCat = findViewById(R.id.rv_miaw)
        rvCat.setHasFixedSize(true)

        list.addAll(DataKucing.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvCat.layoutManager = LinearLayoutManager(this)
        val listCatAdapter = ListCatAdapter(list)
        rvCat.adapter = listCatAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.item1 -> {
                val aabout = Intent(this@MainActivity, about::class.java)
                startActivity(aabout)
            }
        }
    }
}