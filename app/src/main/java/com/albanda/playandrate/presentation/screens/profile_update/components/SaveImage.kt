package com.albanda.playandrate.presentation.screens.profile_update.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.presentation.components.ProgressBar
import com.albanda.playandrate.presentation.screens.profile_update.ProfileUpdateViewModel

@Composable
fun SaveImage(profileUpdateViewModel: ProfileUpdateViewModel = hiltViewModel()) {

    when (val response = profileUpdateViewModel.saveImageResponse) {
        Response.Loading -> ProgressBar()
        is Response.Success<*> -> profileUpdateViewModel.onUpdate(response.data.toString())
        is Response.Failure<*> -> {
            Toast.makeText(
                LocalContext.current,
                response.exception?.message ?: "Error desconocido",
                Toast.LENGTH_LONG
            ).show()
        }
        null -> { }
    }

}