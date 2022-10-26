package com.example.lastfmapp.data.repository.topalbumRepository

import com.example.lastfmapp.core.HandleApiRequest
import com.example.lastfmapp.core.response.HandleResponse
import com.example.lastfmapp.data.api.ApiService
import com.example.lastfmapp.data.model.topAlbum.TopAlbum
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TopAlbumRepoImpl @Inject constructor(
    private val apiService: ApiService ,
    private val handleApiRequest: HandleApiRequest ,
): TopAlbumRepo{
    override suspend fun fetchTopAlbum(tag: String): Flow<HandleResponse<TopAlbum>> =
       handleApiRequest.handleApiRequest {
           apiService.getTopAlbums(tag = tag)

       }

    }
