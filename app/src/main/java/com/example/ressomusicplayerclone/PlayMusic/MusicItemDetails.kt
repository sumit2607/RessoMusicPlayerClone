package com.example.ressomusicplayerclone.PlayMusic

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.bumptech.glide.Glide
import com.example.ressomusicplayerclone.R
import kotlinx.android.synthetic.main.activity_music_item_details.*

class MusicItemDetails : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_item_details)

        val bundleData = intent.getBundleExtra("bundleData")
        tvArtistNameDetail.text = bundleData!!.getString("artistName")
        tvCollectionNameDetail.text = bundleData!!.getString("collectionName")
        tvTrackNameDetail.text = bundleData!!.getString("trackName")
        Glide.with(ivImageDetail).load(bundleData!!.getString("previewImage")).into(ivImageDetail)

        mediaPlayer =
            MediaPlayer.create(applicationContext, Uri.parse(bundleData!!.getString("music")))

        btnPlay.setOnClickListener() {
            mediaPlayer.start()
            createNotification(bundleData!!.getString("trackName"))

        }

        btnPause.setOnClickListener() {
            mediaPlayer.pause()

            NotificationManagerCompat.from(applicationContext).cancelAll()
        }
    }

    private fun createNotification(str: String?) {
        NotificationManagerCompat.from(applicationContext).cancelAll()
        val notificationManager =
            applicationContext.applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                "Hello World",
                "Hello World 2",
                NotificationManager.IMPORTANCE_HIGH

            )
            notificationChannel.enableLights(true)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val builder =
            NotificationCompat.Builder(applicationContext.applicationContext, "Hello World")
                .setContentTitle(str)
                .setContentText("$str Hello")
                .setSmallIcon(R.mipmap.ic_launcher_round)
        notificationManager.notify(1, builder.build())
    }


}