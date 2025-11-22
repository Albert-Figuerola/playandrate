package com.albanda.playandrate.data.mapper.user

import com.albanda.playandrate.data.model.entity.user.UserEntity
import com.albanda.playandrate.domain.model.User

internal fun User.toUserEntity(): UserEntity {
    return UserEntity(
        id,
        username,
        alias,
        image,
        email
    )
}