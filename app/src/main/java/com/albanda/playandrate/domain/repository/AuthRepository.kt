package com.albanda.playandrate.domain.repository

import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.domain.model.User
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    val currentUser: FirebaseUser?
    val isUserAuthenticated: Boolean

    suspend fun login(email: String, password: String): Response<FirebaseUser>
    suspend fun signUp(user: User): Response<FirebaseUser>

    fun logout()

}