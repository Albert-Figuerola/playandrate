package com.albanda.playandrate.presentation.screens.posts.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.albanda.playandrate.domain.model.Post

@Composable
fun PostsContent(
    navHostController: NavHostController,
    posts: List<Post>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .padding(bottom = 80.dp)
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        items(
            items = posts
        ) { post ->
            PostsCard(navHostController = navHostController, post = post)
        }
    }
}