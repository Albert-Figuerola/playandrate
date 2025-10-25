package com.albanda.playandrate.domain.usecase.user

import com.albanda.playandrate.domain.repository.UserRepository
import javax.inject.Inject

class GetUserById @Inject constructor(private val userRepository: UserRepository) {

    operator fun invoke(userId: String) = userRepository.getUserById(userId)

}