package com.example.lastfmapp.data.api

import com.example.lastfmapp.data.model.albumgetInfo.AlbumGetInfo
import com.example.lastfmapp.data.model.search.AlbumSearch
import com.example.lastfmapp.data.model.topAlbum.TopAlbum
import com.example.lastfmapp.data.model.topTag.GenresResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("2.0/")
    suspend fun getTopGenres(
        @Query("method") method: String = "tag.getTopTags" ,
        @Query("api_key") apiKey: String ,
        @Query("format") format: String = "json" ,
    ): Response<GenresResponseModel>


    @GET("2.0/")
    suspend fun getTopAlbums(
        @Query("method") method: String = "tag.getTopAlbums" ,
        @Query("tag") tag: String ,
        @Query("api_key") apiKey: String = "8a0e338471e81bb0dffeaa37600d414b" ,
        @Query("format") format: String = "json"
    ): Response<TopAlbum>

    @GET("2.0/")
    suspend fun searchTopAlbum(
        @Query("method") method: String = "album.search",
        @Query("album") album: String ,
        @Query("api_key") apiKey: String = "8a0e338471e81bb0dffeaa37600d414b" ,
        @Query("format") format: String = "json"
    ): Response<AlbumSearch>

    @GET("2.0/")
    suspend fun getAlbumInfo(
        @Query("method") method: String = "album.getinfo",
        @Query("api_key") apiKey: String = "8a0e338471e81bb0dffeaa37600d414b" ,
        @Query("artist") artist: String,
        @Query("album") album: String,
        @Query("format") format: String = "json"
    ): Response<AlbumGetInfo>





}