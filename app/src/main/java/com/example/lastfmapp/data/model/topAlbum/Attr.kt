package com.example.lastfmapp.data.model.topAlbum


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Attr(
    @SerializedName("rank")
    val rank: String
)