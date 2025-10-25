package com.albanda.playandrate.domain.repository

import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.domain.model.User
import kotlinx.coroutines.flow.Flow
import java.io.File

interface UserRepository {

    suspend fun createUser(user: User): Response<Boolean>

    suspend fun updateUser(user: User): Response<Boolean>

    suspend fun saveImage(file: File): Response<String>

    fun getUserById(userId: String): Flow<User>

}