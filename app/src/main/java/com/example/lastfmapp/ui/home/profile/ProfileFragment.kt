package com.example.lastfmapp.ui.home.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.lastfmapp.R
import com.example.lastfmapp.databinding.FragmentProfileBinding
import com.example.lastfmapp.ui.base.BaseFragment

class ProfileFragment : BaseFragment<ProfileViewModel,FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    override val viewModel: ProfileViewModel by viewModels()


    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
    }



}