package com.example.lastfmapp.data.model.topAlbum


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Albums(
    @SerializedName("album")
    val album: List<Album>?

)