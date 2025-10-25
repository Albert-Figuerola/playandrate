package com.albanda.playandrate.domain.repository

import com.albanda.playandrate.domain.model.Post
import com.albanda.playandrate.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface PostRepository {

    suspend fun createPost(post: Post, file: File): Response<Boolean>

    fun getPosts(): Flow<Response<List<Post>>>

    fun getPostsByUserId(userId: String): Flow<Response<List<Post>>>

    suspend fun deletePost(postId: String): Response<Boolean>

    suspend fun updatePost(post: Post, file: File?): Response<Boolean>

    suspend fun createLike(postId: String, userId: String): Response<Boolean>

    suspend fun deleteLike(postId: String, userId: String): Response<Boolean>

}