package com.albanda.playandrate.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Post(
    var id: String = "",
    var name: String = "",
    var description: String = "",
    var category: String = "",
    var image: String = "",
    var userId: String = "",
    var user: User? = null,
    var score: Int = 0,
    var likes: ArrayList<String> = ArrayList(),
    var createdAt: String = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm"))
) {
    fun toJson(): String = Gson().toJson(
        Post(
            id,
            name,
            description,
            category,
            if (image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
            userId,
            User(
                id = user?.id ?: "",
                username = user?.username ?: "",
                alias = user?.alias ?: "",
                image = if (!user?.image.isNullOrBlank()) URLEncoder.encode(user?.image, StandardCharsets.UTF_8.toString()) else "",
                email = user?.email ?: ""
            ),
            score,
            likes,
            createdAt
        )
    )

    companion object {
        fun fromJson(data: String): Post = Gson().fromJson(data, Post::class.java)
    }
}