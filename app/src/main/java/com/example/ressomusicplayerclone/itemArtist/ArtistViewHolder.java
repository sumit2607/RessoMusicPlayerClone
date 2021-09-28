package com.example.ressomusicplayerclone.itemArtist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ressomusicplayerclone.R;

public class ArtistViewHolder extends RecyclerView.ViewHolder {
    private ImageView img;
    private TextView txt;

    public ArtistViewHolder(@NonNull View itemView) {
        super(itemView);
        initview(itemView);
    }

    private void initview(View itemView) {
        img = itemView.findViewById(R.id.image);
        txt = itemView.findViewById(R.id.title);
    }
}
