package com.albanda.playandrate.domain.usecase.user

import com.albanda.playandrate.domain.repository.UserRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetUserAndSaveInRoom @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(userId: String) {
        val user = userRepository.getUserById(userId).first()
        userRepository.saveUserInRoom(user)
    }
}