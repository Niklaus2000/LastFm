package com.example.lastfmapp.ui.splash

import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val _splashFlow = MutableSharedFlow<Boolean>()
    val splashFlow: MutableSharedFlow<Boolean> get() = _splashFlow



    init {
        viewModelScope.launch {
            delay(5000)
            _splashFlow.emit(true)
        }
    }
}