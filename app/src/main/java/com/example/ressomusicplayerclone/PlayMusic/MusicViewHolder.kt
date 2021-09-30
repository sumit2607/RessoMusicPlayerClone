package com.example.ressomusicplayerclone.PlayMusic

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicpreviewsprintiv.Result
import kotlinx.android.synthetic.main.item_layout.view.*

class MusicViewHolder(private val view: View, private val onClickListener: OnClickListener) :
    RecyclerView.ViewHolder(view) {

    fun getData(result: Result) {
        view.apply {
            tvTrackName.text = result.trackName
            tvArtistName.text = result.artistName
            tvCollectionName.text = result.collectionName
            Glide.with(ivImage).load(result.artworkUrl100).into(ivImage)
        }

        view.setOnClickListener {
            onClickListener.getData(adapterPosition, result)
        }
    }


}