package com.example.lastfmapp.data.model.search


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Results(
    @SerializedName("albummatches")
    val albummatches: Albummatches?,
    @SerializedName( "@attr")
    val attr: Attr?,
    @SerializedName("opensearch:itemsPerPage")
    val opensearchItemsPerPage: String?,
    @SerializedName("opensearch:Query")
    val opensearchQuery: OpensearchQuery?,
    @SerializedName("opensearch:startIndex")
    val opensearchStartIndex: String?,
    @SerializedName( "opensearch:totalResults")
    val opensearchTotalResults: String?
)