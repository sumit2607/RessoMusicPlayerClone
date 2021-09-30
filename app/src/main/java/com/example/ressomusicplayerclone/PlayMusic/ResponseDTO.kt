package com.example.ressomusicplayerclone.PlayMusic


import com.example.musicpreviewsprintiv.Result
import com.google.gson.annotations.SerializedName

data class ResponseDTO(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Result>
)