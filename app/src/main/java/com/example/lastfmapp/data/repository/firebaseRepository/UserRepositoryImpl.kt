package com.example.lastfmapp.data.repository.firebaseRepository

import com.example.lastfmapp.data.model.user.User
import com.example.lastfmapp.core.response.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth ,
) : UserRepository {

    override suspend fun createUser(user: User): AuthResult = try {
        if (user.isCorrectInputRegister()) {
            if (user.isPasswordContains()
            ) {
                firebaseAuth.createUserWithEmailAndPassword(user.email , user.password).await()
            }
        }
        AuthResult.SuccessResult()

    } catch (e: Exception) {
        AuthResult.ErrorResult(e.message!!)
    }

    override suspend fun logIn(user: User): AuthResult = try {
        if (user.isCorrectInputLogin()) {
            firebaseAuth.signInWithEmailAndPassword(user.email , user.password).await()
            AuthResult.SuccessResult()
        } else {
            AuthResult.ErrorResult("Input is not valid.")
        }
    } catch (e: Exception) {
        AuthResult.ErrorResult(e.message!!)
    }

    override suspend fun logOut(user: User) = Unit
}



