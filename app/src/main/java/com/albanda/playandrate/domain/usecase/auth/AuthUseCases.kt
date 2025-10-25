package com.albanda.playandrate.domain.usecase.auth

data class AuthUseCases (
    val login: Login,
    val getCurrentUser: GetCurrentUser,
    val logout: Logout,
    val signup: Signup
)