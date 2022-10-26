package com.example.lastfmapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lastfmapp.R
import com.example.lastfmapp.databinding.FragmentHomeBinding
import com.example.lastfmapp.ui.base.BaseFragment
import com.example.lastfmapp.ui.home.explore.ExploreFragment
import com.example.lastfmapp.ui.home.profile.ProfileFragment
import com.example.lastfmapp.ui.home.saved.SavedFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(FragmentHomeBinding::inflate) {


    override val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        setUpBottomMenu()

    }
    private fun setUpBottomMenu() {

        binding.bottomMenu.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.explore -> {
                    openMainFragment(ExploreFragment())
                    true
                }
                R.id.saved -> {
                    openMainFragment(SavedFragment())
                    true
                }
                R.id.profile -> {
                    openMainFragment(ProfileFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }

    }
    private fun openMainFragment(fragment: Fragment) {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.commit()
    }


}