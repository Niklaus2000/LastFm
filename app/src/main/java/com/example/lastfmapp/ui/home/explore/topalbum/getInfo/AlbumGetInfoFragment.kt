package com.example.lastfmapp.ui.home.explore.topalbum.getInfo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lastfmapp.databinding.FragmentAlbumGetInfoBinding
import com.example.lastfmapp.ui.base.BaseFragment
import com.example.lastfmapp.ui.home.explore.topalbum.getInfo.adapter.AboutAlbumAndTrackListAdapter
import com.google.android.material.tabs.TabLayoutMediator

class AlbumGetInfoFragment : BaseFragment<AlbumGetInfoViewModel, FragmentAlbumGetInfoBinding>(FragmentAlbumGetInfoBinding::inflate) {

    override val viewModel: AlbumGetInfoViewModel by viewModels()


    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        enableTabLayoutMediator()
    }

    private fun enableTabLayoutMediator() {
        val adapter = AboutAlbumAndTrackListAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "AboutAlbum"
                }
                1 -> {
                    tab.text = "TrackList"
                }
            }
        }.attach()

    }





}