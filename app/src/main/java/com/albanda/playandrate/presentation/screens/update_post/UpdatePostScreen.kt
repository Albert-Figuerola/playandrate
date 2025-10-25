package com.albanda.playandrate.presentation.screens.update_post

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
import com.albanda.playandrate.presentation.screens.update_post.components.UpdatePostContent
import com.albanda.playandrate.presentation.screens.update_post.components.UpdatePostResponse

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UpdatePostScreen(
    navHostController: NavHostController,
    updatePostViewModel: UpdatePostViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Editar Post",
                upAvailable = true,
                navHostController = navHostController
            )
        },
        content = {
            UpdatePostContent()
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                text = "Actualizar",
                onClick = { updatePostViewModel.onUpdatePost() }
            )
        }
    )
    UpdatePostResponse(navHostController)
}