package com.example.lastfmapp.ui.home.explore.adapter

import androidx.viewbinding.ViewBinding
import com.example.lastfmapp.ui.base.BaseRecyclerViewAdapter
import com.example.lastfmapp.ui.core.OnItemClick
import com.example.lastfmapp.ui.home.explore.model.GenreUIModel

abstract class BaseItemGenresViewHolder(
    binding: ViewBinding ,
    private val itemClickListener: OnItemClick<GenreUIModel> ,
) : BaseRecyclerViewAdapter.BaseViewHolder<GenreUIModel>(binding.root) {

    override fun bind(item: GenreUIModel) {
        onClick { itemClickListener.onItemClick(item) }
    }
}