package com.example.lastfmapp.ui.home.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lastfmapp.core.Dispatchers
import com.example.lastfmapp.core.response.HandleResponse
import com.example.lastfmapp.data.repository.genresRepository.GenresRepo
import com.example.lastfmapp.ui.home.explore.genresUi.GenresUi
import com.example.lastfmapp.ui.home.explore.model.GenreUIModel
import com.example.lastfmapp.utils.CONSTANTS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val genresRepository: GenresRepo ,
    private val dispatcher: Dispatchers ,
) : ViewModel() {
    private val _listOfGenresState = MutableStateFlow<GenresUi>(GenresUi.Empty)
    val listOfGenresState = _listOfGenresState.asStateFlow()




    fun genres() {
        dispatcher.launchBackground(viewModelScope) {
            genresRepository.fetchGenres(CONSTANTS.API_KEY).collectLatest { it ->
                val genresData = when (it) {
                    is HandleResponse.Loading -> GenresUi.LoadingUi()
                    is HandleResponse.Success -> GenresUi.ContentUi(it.data.toptags.tag!!.map {
                        GenreUIModel(
                            it.name,
                            it.reach
                        ) })
                    is HandleResponse.Error -> GenresUi.ErrorUi(it.message)

                }
                _listOfGenresState.value = genresData
            }
        }
    }

}