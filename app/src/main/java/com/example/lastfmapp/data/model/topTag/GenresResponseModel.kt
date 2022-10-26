package com.example.lastfmapp.data.model.topTag


import com.google.gson.annotations.SerializedName


data class GenresResponseModel(
    @SerializedName("toptags")
    val toptags: TopTags
)