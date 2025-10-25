package com.albanda.playandrate.presentation.screens.profile_update.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.presentation.components.ProgressBar
import com.albanda.playandrate.presentation.screens.profile_update.ProfileUpdateViewModel

@Composable
fun ProfileUpdate(profileUpdateViewModel: ProfileUpdateViewModel = hiltViewModel()) {

    when (val updateResponse = profileUpdateViewModel.updateResponse) {
        Response.Loading -> ProgressBar()

        is Response.Success<*> -> Toast.makeText(
            LocalContext.current,
            "Datos actualizados correctamente",
            Toast.LENGTH_LONG
        ).show()

        is Response.Failure<*> -> Toast.makeText(
            LocalContext.current,
            updateResponse.exception?.message ?: "Error al actualizar datos",
            Toast.LENGTH_LONG
        ).show()

        null -> {}
    }

}