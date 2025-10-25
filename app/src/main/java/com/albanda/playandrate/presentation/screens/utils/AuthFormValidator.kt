package com.albanda.playandrate.presentation.screens.utils

import android.util.Patterns

object AuthFormValidator {

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length >= 6
    }

    fun isConfirmPasswordValid(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }

    fun isUsernameValid(username: String): Boolean {
        return username.length >= 5
    }

}