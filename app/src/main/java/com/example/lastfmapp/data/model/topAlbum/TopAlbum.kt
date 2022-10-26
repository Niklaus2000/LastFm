package com.example.lastfmapp.data.model.topAlbum


import com.example.lastfmapp.data.model.topAlbum.Albums
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class TopAlbum(
    @SerializedName("albums")
    val albums: Albums
)