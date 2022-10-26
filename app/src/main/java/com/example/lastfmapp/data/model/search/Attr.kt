package com.example.lastfmapp.data.model.search


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Attr(
    @SerializedName( "for")
    val forX: String?
)