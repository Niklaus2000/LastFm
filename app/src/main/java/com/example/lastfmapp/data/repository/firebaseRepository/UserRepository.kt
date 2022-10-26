package com.example.lastfmapp.data.repository.firebaseRepository

import com.example.lastfmapp.data.model.user.User
import com.example.lastfmapp.core.response.AuthResult

interface UserRepository {
    suspend fun createUser(user: User): AuthResult
    suspend fun logIn(user: User): AuthResult
    suspend fun logOut(user: User)
}