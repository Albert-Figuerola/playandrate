package com.albanda.playandrate.presentation.screens.posts.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.presentation.components.ProgressBar
import com.albanda.playandrate.presentation.screens.posts.GetPostsViewModel

@Composable
fun LikePost(
    getPostsViewModel: GetPostsViewModel = hiltViewModel()
) {
    when (val response = getPostsViewModel.likeResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success<*> -> {

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