package com.albanda.playandrate.domain.usecase.user

data class UserUseCases(
    val createUser: CreateUser,
    val getUserById: GetUserById,
    val updateUser: UpdateUser,
    val saveImage: SaveImage
)