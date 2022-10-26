package com.example.lastfmapp.ui.home.explore.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.lastfmapp.R
import com.example.lastfmapp.databinding.LayoutItemGenreBinding
import com.example.lastfmapp.ui.base.BaseRecyclerViewAdapter
import com.example.lastfmapp.ui.home.explore.model.GenreUIModel

class GenresItemViewHolder(
    private val binding: LayoutItemGenreBinding ,
) : RecyclerView.ViewHolder(binding.root) , BaseRecyclerViewAdapter.Bind<GenreUIModel> {

    private var onItemClick: ((GenreUIModel) -> Unit)? = null

     override fun bind(item: GenreUIModel) {
         binding.tvGenre.text = item.name
         binding.tvListeners.text = binding.root.context.getString(R.string.listeners_count, item.listeners)

         binding.root.setOnClickListener {
             this.onItemClick = onItemClick
             onItemClick?.invoke(item)
         }

     }
    fun setOnTimeClickListener(onItemClick: (GenreUIModel) -> Unit) {
        this.onItemClick = onItemClick

    }





}