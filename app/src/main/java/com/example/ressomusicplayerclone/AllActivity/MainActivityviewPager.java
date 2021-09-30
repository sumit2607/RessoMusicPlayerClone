package com.example.ressomusicplayerclone.AllActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.ressomusicplayerclone.PlayMusic.MainActivity1;
import com.example.ressomusicplayerclone.R;

public class MainActivityviewPager extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageView mbutton3;

    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityview_pager);

        mbutton3 = findViewById(R.id.button3);
        mbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivityviewPager.this , MainActivity1.class);
                startActivity(intent);
            }
        });


        viewPager = findViewById(R.id.viewpager);



        //setting adapter in viewpager
        viewPager.setAdapter(new MyPagerAdapter());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private class MyPagerAdapter extends PagerAdapter {
        private int[] images;
        private String[] alphabets;
        int[] songs;


        private MyPagerAdapter() {
            this.images = new int[]{R.drawable.ankit, R.drawable.arjit, R.drawable.ankit, R.drawable.arjit};
            this.alphabets = new String[]{"Arjit", "ankit", "atif" ,"arjit"};
            this.songs = new int[]{R.raw.wheels, R.raw.twinkle, R.raw.mary, R.raw.london};

        }

        public int getCount() {

            return this.images.length;
        }

        public boolean isViewFromObject(View view, Object object) {
            return view == (object);
        }

        public Object instantiateItem(ViewGroup container, int position) {


            View view = ((LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.content, container, false);

            //setting text in textview
            ((TextView) view.findViewById(R.id.textview)).setText(this.alphabets[position]);

            //setting image in imageview
            ImageView imageView = view.findViewById(R.id.imageview);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageResource(this.images[position]);

            //play and stop song on button click
            Button btn_play = view.findViewById(R.id.btn_play);
            Button btn_stop = view.findViewById(R.id.btn_stop);


            final int song = songs[position];

            btn_play.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    try {

                        if (mp != null && mp.isPlaying()) {
                            mp.stop();
                            mp.release();

                        }
                        mp = MediaPlayer.create(getApplicationContext(), song);
                        mp.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            });

            btn_stop.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    mp.stop();
                    mp.release();
                    mp = MediaPlayer.create(getApplicationContext(), song);
                }
            });

            //setting view in container i.e viewpager
            container.addView(view);

            return view;

        }

        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);

        }
    }

}
