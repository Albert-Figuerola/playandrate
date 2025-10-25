package com.albanda.playandrate.presentation.screens.detail_post

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.albanda.playandrate.presentation.screens.detail_post.components.DetailPostContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailPostScreen(navHostController: NavHostController, post: String) {
    Scaffold (
        content = {
            DetailPostContent(navHostController)
        }
    )
}