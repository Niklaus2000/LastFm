package com.example.lastfmapp.data.repository.albuminfoRepository

import com.example.lastfmapp.core.HandleApiRequest
import com.example.lastfmapp.core.response.HandleResponse
import com.example.lastfmapp.data.api.ApiService
import com.example.lastfmapp.data.model.albumgetInfo.AlbumGetInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlbumInfoRepoImpl @Inject constructor(
    private val albumInfoService: ApiService ,
    private val handleApiRequest: HandleApiRequest ,
) : AlbumInfoRepo {
    override suspend fun fetchAlbumInfo(artist: String , album: String): Flow<HandleResponse<AlbumGetInfo>> =
        handleApiRequest.handleApiRequest {
            albumInfoService.getAlbumInfo(artist = artist, album = album)

        }
}


