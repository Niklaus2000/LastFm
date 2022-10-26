package com.example.lastfmapp.di.firebaseUsers


import com.example.lastfmapp.data.repository.firebaseRepository.UserRepository
import com.example.lastfmapp.data.repository.firebaseRepository.UserRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UsersModule {

    @Binds
    @Singleton
    abstract fun getUsersRepo(userRepoImpl: UserRepositoryImpl): UserRepository

    companion object {
        @Provides
        fun getUserRepoImpl(firebaseAuth: FirebaseAuth): UserRepositoryImpl =
            UserRepositoryImpl(firebaseAuth)

        @Provides
        fun getFirebaseAuth() = Firebase.auth
    }


}