package com.dicoding.picodiploma.kucingkucing.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.picodiploma.kucingkucing.R
import com.dicoding.picodiploma.kucingkucing.detail
import com.dicoding.picodiploma.kucingkucing.model.Kucing

public class ListCatAdapter (private val listMiaw: ArrayList<Kucing>): RecyclerView.Adapter<ListCatAdapter.ListViewHolder>(){


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_miaw, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMiaw.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val cat = listMiaw[position]

        Glide.with(holder.itemView.context)
            .load(cat.photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.TVname.text = cat.nama
        holder.TVchar.text = cat.karakteristik



        val mcontext = holder.itemView.context
        holder.itemView.setOnClickListener {
            val move = Intent(mcontext, detail::class.java)
            move.putExtra(detail.EXTRA_NAME, cat.nama)
            move.putExtra(detail.EXTRA_CHAR, cat.karakteristik)
            move.putExtra(detail.EXTRA_PHOTO, cat.photo)
            move.putExtra(detail.EXTRA_ASAL, cat.asalUsul)
            move.putExtra(detail.EXTRA_HABIT, cat.detail)
            move.putExtra(detail.EXTRA_TNT, cat.tips)
            mcontext.startActivity(move)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var TVname: TextView = itemView.findViewById(R.id.tv_item_name)
        var TVchar: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}
