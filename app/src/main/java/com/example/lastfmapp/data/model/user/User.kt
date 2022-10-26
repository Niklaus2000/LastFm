package com.example.lastfmapp.data.model.user

data class User(
    val email: String ,
    val password: String ,
    val repeatPassword: String? = null ,
) {
    fun isCorrectInputLogin() = email.isNotEmpty() && password.isNotEmpty()
    fun isCorrectInputRegister() =
        email.isNotEmpty() && password.isNotEmpty() && repeatPassword!!.isNotEmpty()

    fun isPasswordContains() =
        password == repeatPassword && password.contains(Regex(".{6,}")) && password.contains(Regex("(?=.*[A-Z])"))
}