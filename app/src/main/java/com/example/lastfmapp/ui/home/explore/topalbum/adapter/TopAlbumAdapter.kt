package com.example.lastfmapp.ui.home.explore.topalbum.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lastfmapp.databinding.LayoutItemAlbumBinding
import com.example.lastfmapp.ui.home.explore.topalbum.model.TopAlbumUiModel

class TopAlbumAdapter: RecyclerView.Adapter<TopAlbumAdapter.TopAlbumHolder>() {
    private val itemList = mutableListOf<TopAlbumUiModel>()
    private var onItemClick: ((TopAlbumUiModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): TopAlbumAdapter.TopAlbumHolder {
        return TopAlbumHolder(
            LayoutItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopAlbumAdapter.TopAlbumHolder , position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    fun updateAll(list: List<TopAlbumUiModel>) {
        this.itemList.clear()
        this.itemList.addAll(list)
        notifyDataSetChanged()
    }
    fun setOnTimeClickListener(onItemClick: ((TopAlbumUiModel) -> Unit) ) {
        this.onItemClick = onItemClick
    }


    inner class TopAlbumHolder(private val binding: LayoutItemAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(album: TopAlbumUiModel) : Unit = with(binding) {

            titleNameTextView.text = album.title
            artistNameTextView.text = album.artist
            positionNumberTextView.text = album.rank






        }
    }
}