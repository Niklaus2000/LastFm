package com.example.lastfmapp.ui.home.explore.topalbum

import android.app.ProgressDialog.show
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lastfmapp.core.Dispatchers
import com.example.lastfmapp.core.response.HandleResponse
import com.example.lastfmapp.data.api.ApiService
import com.example.lastfmapp.data.model.topAlbum.TopAlbum
import com.example.lastfmapp.data.repository.topalbumRepository.TopAlbumRepo
import com.example.lastfmapp.data.repository.topalbumRepository.searchRepository.TopSearchRepo
import com.example.lastfmapp.ui.home.explore.genresUi.GenresUi
import com.example.lastfmapp.ui.home.explore.model.GenreUIModel
import com.example.lastfmapp.ui.home.explore.topalbum.albumUi.TopAlbumUi
import com.example.lastfmapp.ui.home.explore.topalbum.model.TopAlbumUiModel
import com.example.lastfmapp.utils.CONSTANTS
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject


@HiltViewModel
class TopAlbumViewModel @Inject constructor(
    private val topAlbumRepo: TopAlbumRepo ,
    private val searchRepo: TopSearchRepo ,
    private val dispatchers: Dispatchers ,
) : ViewModel() {

    private val _listOfTopAlbumState = MutableStateFlow<TopAlbumUi>(TopAlbumUi.Empty)
    val listOfTopAlbumState = _listOfTopAlbumState.asStateFlow()

    private val _listOfSearchState = MutableStateFlow<TopAlbumUi>(TopAlbumUi.Empty)
    val listOfSearchState = _listOfSearchState.asStateFlow()

    fun topAlbum(tag: String) {
        dispatchers.launchBackground(viewModelScope) {
            topAlbumRepo.fetchTopAlbum(tag).collectLatest {
                val topAlbumData = when (it) {
                    is HandleResponse.Loading -> TopAlbumUi.LoadingUi()
                    is HandleResponse.Success -> TopAlbumUi.ContentUi(it.data.albums.album!!.map {
                        TopAlbumUiModel(
                            it.name!! ,
                            it.artist!!.name)
                        //   it.attr!!.rank)
//                        it.image!!.find { it!!.size == "large"
//                        }
//                    )
                    })
                    is HandleResponse.Error -> TopAlbumUi.ErrorUi(it.message)
                }
                _listOfTopAlbumState.value = topAlbumData
            }
        }
    }

    fun searchAlbum(search: String) {
        dispatchers.launchBackground(viewModelScope) {
            searchRepo.fetchSearch(search).collectLatest {
                val searchData = when (it) {
                    is HandleResponse.Loading ->  TopAlbumUi.LoadingUi()
                    is HandleResponse.Success -> TopAlbumUi.ContentUi(it.data.results!!.albummatches!!.album!!.map {  TopAlbumUiModel(it!!.name, it!!.artist) })
                    is  HandleResponse.Error -> TopAlbumUi.ErrorUi(it.message)
                }
                _listOfSearchState.value = searchData
            }
        }
    }

}



