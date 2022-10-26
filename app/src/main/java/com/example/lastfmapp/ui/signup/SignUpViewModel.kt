package com.example.lastfmapp.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lastfmapp.data.model.user.User
import com.example.lastfmapp.data.repository.firebaseRepository.UserRepository
import com.example.lastfmapp.core.response.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val channel = Channel<AuthResult>()
    val channelFlow = channel.receiveAsFlow()

    fun register(user: User) {
        viewModelScope.launch {
            channel.send(userRepository.createUser(user))
        }
    }

}