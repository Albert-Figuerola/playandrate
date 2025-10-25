package com.albanda.playandrate.domain.usecase.user

import com.albanda.playandrate.domain.repository.UserRepository
import java.io.File
import javax.inject.Inject

class SaveImage @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(file: File) = userRepository.saveImage(file)

}