package com.example.lastfmapp.core.response

import android.view.View
import com.example.lastfmapp.extension.showSnack

interface AuthResult {

    fun applyResult(view: View)

    class SuccessResult : AuthResult {
        override fun applyResult(view: View) {
            view.showSnack("TRUE")
        }
    }

    class ErrorResult(private val message: String) : AuthResult {
        override fun applyResult(view: View) {
            view.showSnack(message)
        }
    }
}