package com.example.lastfmapp.ui.home.explore.topalbum.albumUi

import android.view.View
import com.example.lastfmapp.data.model.topAlbum.Album
import com.example.lastfmapp.databinding.FragmentTopAlbumBinding
import com.example.lastfmapp.ui.home.explore.topalbum.adapter.TopAlbumAdapter
import com.example.lastfmapp.ui.home.explore.topalbum.model.TopAlbumUiModel


interface TopAlbumUi  {
    fun apply(binding: FragmentTopAlbumBinding , adapter: TopAlbumAdapter)

    object Empty : TopAlbumUi {
        override fun apply(binding: FragmentTopAlbumBinding , adapter: TopAlbumAdapter) = Unit
    }

    class LoadingUi : TopAlbumUi {
        override fun apply(
            binding: FragmentTopAlbumBinding ,
            adapter: TopAlbumAdapter ,
        ) {
            binding.progressBar.visibility = View.VISIBLE
        }
    }

    class ContentUi(private val items: List<TopAlbumUiModel>) : TopAlbumUi {
        override fun apply(
            binding: FragmentTopAlbumBinding ,
            adapter: TopAlbumAdapter ,
        ) {
            binding.progressBar.visibility = View.GONE
            adapter.updateAll(items)



        }
    }

    class ErrorUi(private val errorMessage: String) : TopAlbumUi {
        override fun apply(
            binding: FragmentTopAlbumBinding ,
            adapter: TopAlbumAdapter ,
        ) = with(binding) {
            progressBar.visibility = View.GONE
        }
    }
}