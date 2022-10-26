package com.example.lastfmapp.data.model.search


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Album(
    @SerializedName("artist")
    val artist: String?,
    @SerializedName("image")
    val image: List<Image?>?,
    @SerializedName("mbid")
    val mbid: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("streamable")
    val streamable: String?,
    @SerializedName("url")
    val url: String?
)