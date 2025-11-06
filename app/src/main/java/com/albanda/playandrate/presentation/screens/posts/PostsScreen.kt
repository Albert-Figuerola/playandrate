package com.albanda.playandrate.presentation.screens.posts

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.albanda.playandrate.presentation.screens.posts.components.DeleteLikePost
import com.albanda.playandrate.presentation.screens.posts.components.GetPosts
import com.albanda.playandrate.presentation.screens.posts.components.LikePost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PostsScreen(
    navHostController: NavHostController,
    getPostsViewModel: GetPostsViewModel = hiltViewModel()
) {
    Scaffold (
        content = { innerPadding ->
            GetPosts(
                modifier = Modifier
                    .padding(innerPadding),
                navHostController,
                getPostsViewModel
            )
        }
    )
    LikePost()
    DeleteLikePost()
}