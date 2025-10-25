package com.albanda.playandrate.domain.usecase.auth

import com.albanda.playandrate.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String) = authRepository.login(email, password)
}