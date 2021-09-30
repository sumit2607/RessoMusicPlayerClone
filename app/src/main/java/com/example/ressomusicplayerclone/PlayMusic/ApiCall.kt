package com.example.ressomusicplayerclone.PlayMusic

import com.example.ressomusicplayerclone.PlayMusic.ResponseDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {

    @GET("search")
    fun setData(@Query("term") term: String): Call<ResponseDTO>
}