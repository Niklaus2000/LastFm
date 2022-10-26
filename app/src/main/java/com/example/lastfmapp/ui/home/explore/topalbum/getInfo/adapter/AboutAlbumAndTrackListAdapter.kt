package com.example.lastfmapp.ui.home.explore.topalbum.getInfo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lastfmapp.ui.home.explore.topalbum.getInfo.aboutAlbum.AboutAlbumFragment
import com.example.lastfmapp.ui.home.explore.topalbum.getInfo.trackList.TrackListFragment


class AboutAlbumAndTrackListAdapter(fragmentManager: FragmentManager , lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager , lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0->{
                AboutAlbumFragment()
            }
            1->{
                TrackListFragment()
            }
            else ->{
                Fragment()
            }

        }
    }


}