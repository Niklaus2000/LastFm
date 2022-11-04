package com.example.lastfmapp.ui.home.explore

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lastfmapp.databinding.FragmentExploreBinding
import com.example.lastfmapp.ui.base.BaseFragment
import com.example.lastfmapp.ui.core.OnItemClick
import com.example.lastfmapp.ui.home.explore.adapter.GenresAdapter
import com.example.lastfmapp.ui.home.explore.model.GenreUIModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExploreFragment :
    BaseFragment<ExploreViewModel , FragmentExploreBinding>(FragmentExploreBinding::inflate),
    OnItemClick<GenreUIModel> {

    override val viewModel: ExploreViewModel by viewModels()
    private lateinit var genresAdapter: GenresAdapter




    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        initAdapter()

        viewModel.genres()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.listOfGenresState.collect {
                it.apply(binding, genresAdapter)

            }
        }

    }

    private fun initAdapter(): Unit = with(binding) {
        genresAdapter = GenresAdapter(this@ExploreFragment)
        rvGenres.adapter = genresAdapter
        rvGenres.layoutManager = LinearLayoutManager(requireContext())

    }

    override fun onItemClick(item: GenreUIModel) {findNavController().navigate(
        ExploreFragmentDirections.actionExploreFragmentToTopAlbumFragment(item.name.toString()))}
}