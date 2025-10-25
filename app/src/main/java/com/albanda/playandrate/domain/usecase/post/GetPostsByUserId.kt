package com.albanda.playandrate.domain.usecase.post

import com.albanda.playandrate.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsByUserId @Inject constructor(
    private val postRepository: PostRepository
) {

    operator fun invoke(userId: String) = postRepository.getPostsByUserId(userId)

}