package com.albanda.playandrate.domain.usecase.auth

import com.albanda.playandrate.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke() = authRepository.currentUser
}