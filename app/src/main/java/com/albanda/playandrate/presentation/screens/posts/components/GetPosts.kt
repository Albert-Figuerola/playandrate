package com.albanda.playandrate.presentation.screens.posts.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.albanda.playandrate.domain.model.Post
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.presentation.components.ProgressBar
import com.albanda.playandrate.presentation.screens.posts.GetPostsViewModel

@Composable
fun GetPosts(
    navHostController: NavHostController,
    getPostsViewModel: GetPostsViewModel = hiltViewModel()
) {
    when (val response = getPostsViewModel.postsResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success<*> -> {
            PostsContent(navHostController, posts = response.data as List<Post>)
        }

        is Response.Failure<*> -> {
            Toast.makeText(
                LocalContext.current,
                response.exception?.message ?: "Error desconocido",
                Toast.LENGTH_LONG
            ).show()
        }

        null -> {}
    }
}