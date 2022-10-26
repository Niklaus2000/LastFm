package com.example.lastfmapp.data.model.topTag


import com.google.gson.annotations.SerializedName



data class TopTags(
    @SerializedName("tag")
    val tag: List<Tag>?
)