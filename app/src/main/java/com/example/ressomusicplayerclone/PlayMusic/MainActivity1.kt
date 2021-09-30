package com.example.ressomusicplayerclone.PlayMusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicpreviewsprintiv.*
import com.example.ressomusicplayerclone.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main1.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity1 : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        btnSearch.setOnClickListener() {
            buildData()
        }
    }


    //building the data
    private fun buildData() {
        val apiCall = Network.retrofitInstance.create(ApiCall::class.java)
        val searchMusic: String = etSearchMusic.text.toString()
        apiCall.setData(searchMusic).enqueue(object : Callback<ResponseDTO> {
            override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                response.body()?.run {

                    val gridLayoutManager = GridLayoutManager(applicationContext, 2)
                    val musicAdapter = MusicAdapter(
                        response.body()!!.results as ArrayList<Result>,
                        this@MainActivity1
                    )
                    recyclerView.apply {
                        layoutManager = gridLayoutManager
                        adapter = musicAdapter
                    }
                }


            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
            }

        })
    }


    // on click listener method
    override fun getData(position: Int, result: Result) {
        Toast.makeText(this, "Opening Music Item", Toast.LENGTH_SHORT).show()
        //   <!--    Track Name, Preview Image, Artist Name, Collection Name-->

        val bundle = Bundle()

        bundle.putString("trackName", result.trackName)
        bundle.putString("previewImage", result.artworkUrl100)
        bundle.putString("artistName", result.artistName)
        bundle.putString("collectionName", result.collectionName)

        bundle.putString("music", result.previewUrl)

        // bundle.putString("bundleData",bundle)
        val intent = Intent(applicationContext, MusicItemDetails::class.java)
        intent.putExtra("bundleData", bundle)
        startActivity(intent)
    }
}