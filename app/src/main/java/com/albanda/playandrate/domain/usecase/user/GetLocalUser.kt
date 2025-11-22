package com.albanda.playandrate.domain.usecase.user

import com.albanda.playandrate.domain.repository.UserRepository
import javax.inject.Inject

class GetLocalUser @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke() = userRepository.getLocalUser()
}