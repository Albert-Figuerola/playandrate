package com.albanda.playandrate.domain.usecase.post

data class PostUseCases (
    val createPost: CreatePost,
    val getPosts: GetPosts,
    val getPostsByUserId: GetPostsByUserId,
    val deletePost: DeletePost,
    val updatePost: UpdatePost,
    val createLikePost: CreateLikePost,
    val deleteLikePost: DeleteLikePost
)