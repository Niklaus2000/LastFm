package com.example.lastfmapp.ui.signin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lastfmapp.R
import com.example.lastfmapp.data.model.user.User
import com.example.lastfmapp.databinding.FragmentSignInBinding
import com.example.lastfmapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : BaseFragment<SignInViewModel,FragmentSignInBinding>(FragmentSignInBinding::inflate){

    override val viewModel: SignInViewModel by viewModels()

    override fun onViewCreated(view: View , savedInstanceState: Bundle?)  {
        super.onViewCreated(view , savedInstanceState)

        initView()


    }

    private fun initView(): Unit = with(binding) {
        loginButton.setOnClickListener {
            val email = emailEditTextView.text.toString().trim()
            val password = passwordEditTextView.text.toString().trim()
            val user = User(email = email , password = password)
            viewModel.login(user)
        }
        collectFlow(viewModel.channelFlow) {
            findNavController().navigate(R.id.homeFragment)
        }
        signTextView.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }
    }



}