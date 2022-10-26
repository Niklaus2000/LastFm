package com.example.lastfmapp.ui.splash

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.lastfmapp.R
import com.example.lastfmapp.databinding.FragmentSplashBinding
import com.example.lastfmapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment :
    BaseFragment<SplashViewModel , FragmentSplashBinding>(FragmentSplashBinding::inflate) {

     override val viewModel: SplashViewModel by viewModels()


    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)




        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.splashFlow.collect {
                val sideAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.side_slide)
                binding.imageView.startAnimation(sideAnimation)
                findNavController().navigate(R.id.action_splashFragment_to_signInFragment)

            }
        }

    }


}