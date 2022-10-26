package com.example.lastfmapp.ui.home.explore.genresUi

import android.view.View
import com.example.lastfmapp.databinding.FragmentExploreBinding
import com.example.lastfmapp.ui.home.explore.adapter.GenresAdapter
import com.example.lastfmapp.ui.home.explore.model.GenreUIModel

interface GenresUi {
    fun apply(binding: FragmentExploreBinding , adapter: GenresAdapter)

    object Empty : GenresUi {
        override fun apply(binding: FragmentExploreBinding , adapter: GenresAdapter) = Unit
    }
    class LoadingUi : GenresUi {
        override fun apply(
            binding: FragmentExploreBinding ,
            adapter: GenresAdapter ,
        ) {
            binding.progressBar.visibility = View.VISIBLE
        }
    }

    class ContentUi(private val items: List<GenreUIModel>) : GenresUi {
        override fun apply(
            binding: FragmentExploreBinding ,
            adapter: GenresAdapter ,
        ) {
            binding.progressBar.visibility = View.GONE
            adapter.updateAll(items)
        }
    }

    class ErrorUi(private val errorMessage: String) : GenresUi {
        override fun apply(
            binding: FragmentExploreBinding ,
            adapter: GenresAdapter ,
        ) = with(binding) {
            progressBar.visibility = View.GONE


        }
    }


}