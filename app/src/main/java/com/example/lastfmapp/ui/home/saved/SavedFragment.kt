package com.example.lastfmapp.ui.home.saved

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.lastfmapp.databinding.FragmentSavedBinding
import com.example.lastfmapp.ui.base.BaseFragment

class SavedFragment : BaseFragment<SavedViewModel, FragmentSavedBinding>(FragmentSavedBinding::inflate) {

    override val viewModel: SavedViewModel by viewModels()

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
    }

}