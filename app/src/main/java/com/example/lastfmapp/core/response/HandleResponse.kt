package com.example.lastfmapp.core.response

sealed class HandleResponse<T> {
    class Loading<T> : HandleResponse<T>()
    data class Success<T>(val data: T): HandleResponse<T>()
    data class Error<T>(val message: String): HandleResponse<T>()
}