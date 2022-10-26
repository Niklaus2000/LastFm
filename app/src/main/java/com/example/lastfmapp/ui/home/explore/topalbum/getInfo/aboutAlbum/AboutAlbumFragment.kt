package com.example.lastfmapp.ui.home.explore.topalbum.getInfo.aboutAlbum

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lastfmapp.R

class AboutAlbumFragment : Fragment() {

    companion object {
        fun newInstance() = AboutAlbumFragment()
    }

    private lateinit var viewModel: AboutAlbumViewModel

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle? ,
    ): View? {
        return inflater.inflate(R.layout.fragment_about_album , container , false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AboutAlbumViewModel::class.java)
        // TODO: Use the ViewModel
    }

}