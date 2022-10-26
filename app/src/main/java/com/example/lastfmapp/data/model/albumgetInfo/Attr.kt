package com.example.lastfmapp.data.model.albumgetInfo


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Attr(
    @Json(name = "rank")
    val rank: Int?
)