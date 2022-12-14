package com.example.lastfmapp.data.model.topAlbum


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Album(
    @SerializedName("artist")
    val artist: Artist? ,
    @SerializedName("@attr")
    val attr: Attr? ,
    @SerializedName("image")
    val image: List<Image?>? ,
    @SerializedName("mbid")
    val mbid: String? ,
    @SerializedName("name")
    val name: String? ,
    @SerializedName("url")
    val url: String?
)