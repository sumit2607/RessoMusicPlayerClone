package com.example.ressomusicplayerclone.AllActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.ressomusicplayerclone.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {



                    Intent i = new Intent(SplashScreen.this, LoginScreen.class);
                    startActivity(i);
                    finish();
                }
            }, 3000);
        }


    }
