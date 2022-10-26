package com.example.lastfmapp.data.repository.topalbumRepository

import com.example.lastfmapp.core.response.HandleResponse
import com.example.lastfmapp.data.model.topAlbum.TopAlbum
import kotlinx.coroutines.flow.Flow

interface TopAlbumRepo  {

    suspend fun fetchTopAlbum(name: String): Flow<HandleResponse<TopAlbum>>

}