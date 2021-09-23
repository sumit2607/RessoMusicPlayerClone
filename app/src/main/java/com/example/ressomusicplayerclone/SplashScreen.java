package com.example.ressomusicplayerclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {
    SharedPreferences sharedPreferences;///  i used for sharedPreferences on time spless screen
    boolean firstTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean("firstTime", true);
        if (firstTime) {
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    firstTime = false;
                    editor.putBoolean("firstTime", firstTime);
                    editor.apply();

                    Intent i = new Intent(SplashScreen.this, LoginScreen.class);
                    startActivity(i);
                    finish();
                }
            }, 3000);
        }else {

            Intent i = new Intent(SplashScreen.this, LoginScreen.class);
            startActivity(i);
            finish();

        }


    }
}