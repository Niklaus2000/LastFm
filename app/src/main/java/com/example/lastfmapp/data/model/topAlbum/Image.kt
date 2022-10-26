package com.example.lastfmapp.data.model.topAlbum


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Image(
    @SerializedName("size")
    val size: String?,
    @SerializedName("#text")
    val text: String?
)