package com.albanda.playandrate.presentation.screens.detail_post

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.albanda.playandrate.presentation.components.TopBar
import com.albanda.playandrate.presentation.screens.detail_post.components.DetailPostContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailPostScreen(navHostController: NavHostController) {
    Scaffold (
        topBar = {
            TopBar(
                title = null,
                upAvailable = true,
                navHostController = navHostController
            )
        },
        content = { innerPadding ->
            DetailPostContent(modifier = Modifier
                .padding(innerPadding)
            )
        }
    )
}