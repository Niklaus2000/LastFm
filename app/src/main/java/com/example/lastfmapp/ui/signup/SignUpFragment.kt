package com.example.lastfmapp.ui.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lastfmapp.R
import com.example.lastfmapp.data.model.user.User
import com.example.lastfmapp.databinding.FragmentSignUpBinding
import com.example.lastfmapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment :
    BaseFragment<SignUpViewModel , FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    override val viewModel: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)

        initView()
    }

    private fun initView(): Unit = with(binding) {
        sigUpButton.setOnClickListener {
            val email = emailEditTextView.text.toString().trim()
            val password = passwordEditTextView.text.toString().trim()
            val repeatPassword = repeatPasswordEditTextView.text.toString().trim()
            val user = User(email = email , password = password , repeatPassword = repeatPassword)
            viewModel.register(user)
        }
        collectFlow(viewModel.channelFlow) {
            findNavController().navigate(R.id.homeFragment)
        }
    }


}