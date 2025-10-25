package com.albanda.playandrate.domain.usecase.auth

import com.albanda.playandrate.domain.repository.AuthRepository
import jakarta.inject.Inject

class Logout @Inject constructor(private val authRepository: AuthRepository) {

    operator fun invoke() = authRepository.logout()

}