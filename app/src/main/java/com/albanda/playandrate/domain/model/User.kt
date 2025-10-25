package com.albanda.playandrate.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User(
    var id: String = "",
    var username: String = "",
    var image: String = "",
    var email: String = "",
    var password: String = ""
) {
    fun toJson(): String = Gson().toJson(
        User(
            id,
            username,
            if (image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
            email,
            password
        )
    )

    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }
}