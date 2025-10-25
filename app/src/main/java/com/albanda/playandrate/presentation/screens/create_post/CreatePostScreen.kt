package com.albanda.playandrate.presentation.screens.create_post

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.albanda.playandrate.presentation.components.DefaultButton
import com.albanda.playandrate.presentation.components.DefaultTopBar
import com.albanda.playandrate.presentation.screens.create_post.components.CreatePostResponse
import com.albanda.playandrate.presentation.screens.create_post.components.CreatePostContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreatePostScreen(navHostController: NavHostController, createPostViewModel: CreatePostViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo Post",
                upAvailable = true,
                navHostController = navHostController
            )
        },
        content = {
            CreatePostContent()
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                text = "Publicar",
                onClick = { createPostViewModel.onCreatePost() }
            )
        }
    )
    CreatePostResponse()
}