package com.albanda.playandrate.presentation.screens.update_post.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.presentation.components.ProgressBar
import com.albanda.playandrate.presentation.screens.update_post.UpdatePostViewModel

@Composable
fun UpdatePostResponse(
    navHostController: NavHostController,
    updatePostViewModel: UpdatePostViewModel = hiltViewModel()
) {

    when (val response = updatePostViewModel.updatePostResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success<*> -> {
            updatePostViewModel.clearForm()
            Toast.makeText(
                LocalContext.current,
                "Publicación editada correctamente",
                Toast.LENGTH_LONG
            ).show()
            navHostController.popBackStack()
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