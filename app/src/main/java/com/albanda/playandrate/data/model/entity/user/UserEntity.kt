package com.albanda.playandrate.data.model.entity.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: String,
    var username: String,
    var alias: String,
    var image: String,
    var email: String
)