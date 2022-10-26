package com.example.lastfmapp.data.repository.genresRepository

import com.example.lastfmapp.core.response.HandleResponse
import com.example.lastfmapp.data.model.topAlbum.TopAlbum
import com.example.lastfmapp.data.model.topTag.GenresResponseModel
import kotlinx.coroutines.flow.Flow

interface GenresRepo {
    suspend fun fetchGenres(apiKey: String): Flow<HandleResponse<GenresResponseModel>>

}