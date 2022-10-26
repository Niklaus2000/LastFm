package com.example.lastfmapp.data.repository.topalbumRepository.searchRepository

import com.example.lastfmapp.core.HandleApiRequest
import com.example.lastfmapp.core.response.HandleResponse
import com.example.lastfmapp.data.api.ApiService
import com.example.lastfmapp.data.model.search.AlbumSearch
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopSearchRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val handleApiRequest: HandleApiRequest
): TopSearchRepo {
    override suspend fun fetchSearch(search: String): Flow<HandleResponse<AlbumSearch>> =
        handleApiRequest.handleApiRequest {
          apiService.searchTopAlbum(album = search)
        }
}