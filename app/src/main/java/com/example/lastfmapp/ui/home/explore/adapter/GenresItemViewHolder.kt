package com.example.lastfmapp.ui.home.explore.adapter

import com.example.lastfmapp.databinding.LayoutItemGenreBinding
import com.example.lastfmapp.ui.core.OnItemClick
import com.example.lastfmapp.ui.home.explore.model.GenreUIModel

//

class GenresItemViewHolder(
    private val binding: LayoutItemGenreBinding ,
    itemClickListener: OnItemClick<GenreUIModel> ,
) : BaseItemGenresViewHolder(binding , itemClickListener) {

    override fun bind(item: GenreUIModel) = with(binding) {
        item.bindGereItem(binding)
        super.bind(item)
    }
}
