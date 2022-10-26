package com.example.lastfmapp.ui.home.explore.topalbum.getInfo.trackList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lastfmapp.R

class TrackListFragment : Fragment() {

    companion object {
        fun newInstance() = TrackListFragment()
    }

    private lateinit var viewModel: TrackListViewModel

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle? ,
    ): View? {
        return inflater.inflate(R.layout.fragment_track_list , container , false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TrackListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}