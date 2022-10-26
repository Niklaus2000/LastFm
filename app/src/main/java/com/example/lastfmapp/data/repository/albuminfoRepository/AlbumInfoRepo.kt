package com.example.lastfmapp.data.repository.albuminfoRepository

import com.example.lastfmapp.core.HandleApiRequest
import com.example.lastfmapp.core.response.HandleResponse
import com.example.lastfmapp.data.model.albumgetInfo.AlbumGetInfo
import com.example.lastfmapp.data.model.topAlbum.Artist
import kotlinx.coroutines.flow.Flow

interface AlbumInfoRepo {
    suspend fun fetchAlbumInfo(artist: String, album: String): Flow<HandleResponse<AlbumGetInfo>>
}