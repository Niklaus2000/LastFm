package com.example.lastfmapp.ui.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lastfmapp.ui.home.explore.model.GenreUIModel
import com.example.lastfmapp.ui.home.explore.topalbum.model.TopAlbumUiModel

abstract class BaseRecyclerViewAdapter<T : Any> :
    ListAdapter<T, BaseRecyclerViewAdapter.BaseViewHolder<T>>(BaseItemCallback<T>()) {
    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) =
        holder.bind(getItem(position))

    private val itemList = mutableListOf<GenreUIModel>()



     fun updateAll(items: List<GenreUIModel>) {
        this.itemList.clear()
        this.itemList.addAll(items)
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)


        protected fun onClick(block: () -> Unit) = itemView.setOnClickListener {
            block.invoke()
        }
    }
}

