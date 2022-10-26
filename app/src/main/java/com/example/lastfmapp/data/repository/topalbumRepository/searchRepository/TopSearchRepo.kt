package com.example.lastfmapp.data.repository.topalbumRepository.searchRepository

import com.example.lastfmapp.core.response.HandleResponse
import com.example.lastfmapp.data.model.search.AlbumSearch
import kotlinx.coroutines.flow.Flow

interface TopSearchRepo {
    suspend fun fetchSearch(search: String): Flow<HandleResponse<AlbumSearch>>

}