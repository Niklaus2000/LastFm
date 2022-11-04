package com.example.lastfmapp.ui.home.explore.model

import com.example.lastfmapp.databinding.LayoutItemGenreBinding


data class GenreUIModel(
    val name: String? ,
    val listeners: Int?
){
    fun bindGereItem(binding: LayoutItemGenreBinding
    ) = with(binding) {
        tvGenre.text = name
        tvListeners.text = listeners.toString()

    }

}
