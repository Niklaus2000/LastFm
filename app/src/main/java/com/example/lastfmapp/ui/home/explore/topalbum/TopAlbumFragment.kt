package com.example.lastfmapp.ui.home.explore.topalbum

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lastfmapp.databinding.FragmentTopAlbumBinding
import com.example.lastfmapp.ui.base.BaseFragment
import com.example.lastfmapp.ui.home.explore.ExploreFragmentDirections
import com.example.lastfmapp.ui.home.explore.topalbum.adapter.TopAlbumAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopAlbumFragment :
    BaseFragment<TopAlbumViewModel , FragmentTopAlbumBinding>(FragmentTopAlbumBinding::inflate) {

    override val viewModel: TopAlbumViewModel by viewModels()
    private lateinit var topAlbumAdapter: TopAlbumAdapter

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        initAdapter()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.listOfTopAlbumState.collect {
                it.apply(binding , topAlbumAdapter)
            }
        }

        val safeArgs = TopAlbumFragmentArgs.fromBundle(requireArguments())
        viewModel.topAlbum(tag = safeArgs.naveargs)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.listOfSearchState.collect {
                it.apply(binding , topAlbumAdapter)
            }
        }

        binding.searchButton.setOnClickListener {
            viewModel.searchAlbum(search = binding.searchEditTextView.text.toString())
        }

        topAlbumAdapter.setOnTimeClickListener {




        }
        
    }
    private fun initAdapter(): Unit = with(binding) {
        topAlbumAdapter = TopAlbumAdapter()
        rvTopAlbum.adapter = topAlbumAdapter
        rvTopAlbum.layoutManager = LinearLayoutManager(requireContext())
    }


}




