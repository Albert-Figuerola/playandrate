package com.albanda.playandrate.domain.usecase.user

import com.albanda.playandrate.domain.model.User
import com.albanda.playandrate.domain.repository.UserRepository
import javax.inject.Inject

class CreateUser @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke(user: User) = userRepository.createUser(user)

}