package com.example.lastfmapp.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lastfmapp.core.response.AuthResult
import com.example.lastfmapp.data.model.user.User
import com.example.lastfmapp.data.repository.firebaseRepository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val repository: UserRepository): ViewModel() {

    private val channel = Channel<AuthResult>()
    val channelFlow = channel.receiveAsFlow()

    fun login(user: User) {
        viewModelScope.launch {
            channel.send(repository.logIn(user))
        }
    }
}