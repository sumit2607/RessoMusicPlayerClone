package com.example.ressomusicplayerclone.AllActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ressomusicplayerclone.Model.model;
import com.example.ressomusicplayerclone.R;
import com.example.ressomusicplayerclone.itemArtist.myadapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class music extends AppCompatActivity {
    RecyclerView recview;
    myadapter adapter;
    private Button mbutton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        mbutton2  = findViewById(R.id.button23);
        recview= findViewById(R.id.recyclerView);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("artist"), model.class)
                        .build();

        adapter=new myadapter(options);
        recview.setAdapter(adapter);

        mbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(music.this , MainActivityviewPager.class);
                startActivity(intent
                );
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
