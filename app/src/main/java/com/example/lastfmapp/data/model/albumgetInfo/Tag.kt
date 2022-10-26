package com.example.lastfmapp.data.model.albumgetInfo


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tag(
    @Json(name = "name")
    val name: String?,
    @Json(name = "url")
    val url: String?
)