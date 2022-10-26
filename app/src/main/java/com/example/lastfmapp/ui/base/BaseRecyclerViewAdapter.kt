package com.example.lastfmapp.ui.base

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lastfmapp.ui.home.explore.model.GenreUIModel

abstract class BaseRecyclerViewAdapter<T : Any> :
    ListAdapter<T , RecyclerView.ViewHolder>(BaseItemCallback<T>()) {

    private val itemList = mutableListOf<GenreUIModel>()
    abstract fun getViewHolder(parent: ViewGroup , viewType: Int): RecyclerView.ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): RecyclerView.ViewHolder =
        getViewHolder(parent, viewType)

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder , position: Int) =
        (holder as Bind<T>).bind(getItem(position))

    interface Bind<T> {
        fun bind(item: T)
    }

    fun updateAll(list: List<GenreUIModel>) {
        this.itemList.clear()
        this.itemList.addAll(list)
        notifyDataSetChanged()
    }

    //abstract fun setOnTimeClickListener(onItemClick: (GenreUIModel) -> Unit)
}