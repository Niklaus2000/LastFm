package com.example.lastfmapp.data.repository.genresRepository

import com.example.lastfmapp.core.HandleApiRequest
import com.example.lastfmapp.core.response.HandleResponse
import com.example.lastfmapp.data.api.ApiService
import com.example.lastfmapp.data.model.topTag.GenresResponseModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GenresRepoImpl @Inject constructor(
    private val genresService: ApiService ,
    private val handleApiRequest: HandleApiRequest ,
) : GenresRepo {
    override suspend fun fetchGenres(apiKey: String): Flow<HandleResponse<GenresResponseModel>> =
        handleApiRequest.handleApiRequest {
            genresService.getTopGenres(apiKey = apiKey)
        }




}