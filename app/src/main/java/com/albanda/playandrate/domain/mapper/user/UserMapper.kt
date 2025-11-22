package com.albanda.playandrate.domain.mapper.user

import com.albanda.playandrate.data.model.entity.user.UserEntity
import com.albanda.playandrate.domain.model.User

internal fun UserEntity.toUser(): User {
    return User(
        id,
        username,
        alias,
        image,
        email
    )
}