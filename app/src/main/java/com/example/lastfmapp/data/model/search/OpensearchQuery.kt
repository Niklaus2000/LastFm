package com.example.lastfmapp.data.model.search


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class OpensearchQuery(
    @SerializedName("role")
    val role: String?,
    @SerializedName("searchTerms")
    val searchTerms: String?,
    @SerializedName("startPage")
    val startPage: String?,
    @SerializedName("#text")
    val text: String?
)