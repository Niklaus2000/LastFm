package com.example.lastfmapp.ui.home.explore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lastfmapp.R
import com.example.lastfmapp.databinding.LayoutItemGenreBinding
import com.example.lastfmapp.ui.base.BaseRecyclerViewAdapter
import com.example.lastfmapp.ui.home.explore.model.GenreUIModel

//class GenresAdapter : BaseRecyclerViewAdapter<GenreUIModel>() {
////    private var onItemClick: ((GenreUIModel) -> Unit)? = null
////    private lateinit var genresItemViewHolder: GenresItemViewHolder
//
//
//    override fun getViewHolder(parent: ViewGroup , viewType: Int): RecyclerView.ViewHolder =
//        GenresItemViewHolder(
//            LayoutItemGenreBinding
//                .inflate(
//                    LayoutInflater.from(parent.context) ,
//                    parent ,
//                    false)
//
//
//        )
////    fun setOnTimeClickListener(onItemClick: (GenreUIModel) -> Unit) {
////        this.onItemClick = onItemClick
////        genresItemViewHolder.itemView.setOnClickListener {
////
////
////        }
//
//    }

class GenresAdapter : RecyclerView.Adapter<GenresAdapter.GenresHolder>() {

    private val itemList = mutableListOf<GenreUIModel>()
    private var onItemClick: ((GenreUIModel) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresHolder {
        return GenresHolder(
            LayoutItemGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateAll(list: List<GenreUIModel>) {
        this.itemList.clear()
        this.itemList.addAll(list)
        notifyDataSetChanged()
    }
    fun setOnTimeClickListener(onItemClick: ((GenreUIModel) -> Unit) ) {
        this.onItemClick = onItemClick
    }

    override fun onBindViewHolder(holder: GenresHolder, position: Int) {
        holder.bind(itemList[position])

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class GenresHolder(private val binding: LayoutItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(genre: GenreUIModel) {
            binding.tvGenre.text = genre.name
            binding.tvListeners.text = binding.root.context.getString(R.string.listeners_count, genre.listeners)

            binding.root.setOnClickListener {
                onItemClick?.invoke(genre)
            }
        }
    }

}







