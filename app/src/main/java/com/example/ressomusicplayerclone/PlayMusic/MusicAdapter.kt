package com.example.ressomusicplayerclone.PlayMusic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicpreviewsprintiv.Result
import com.example.ressomusicplayerclone.R

class MusicAdapter(private var list: ArrayList<Result>, var clickListener: OnClickListener) :
    RecyclerView.Adapter<MusicViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MusicViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val result = list[position]
        holder.getData(result)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}