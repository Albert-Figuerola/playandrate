package com.albanda.playandrate.domain.usecase.auth

import com.albanda.playandrate.domain.model.User
import com.albanda.playandrate.domain.repository.AuthRepository
import javax.inject.Inject


class Signup @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(user: User) = authRepository.signUp(user)
}