package com.albanda.playandrate.presentation.screens.signup.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.presentation.components.ProgressBar
import com.albanda.playandrate.presentation.navigation.Graph
import com.albanda.playandrate.presentation.screens.signup.SignupViewModel

@Composable
fun SignUp(
    navHostController: NavHostController,
    signupViewModel: SignupViewModel = hiltViewModel()
) {
    when (val signupResponse = signupViewModel.updateUserImage) {
        Response.Loading -> {
            Log.i("CardForm", "Loading")
            ProgressBar()
        }

        is Response.Success<*> -> {
            LaunchedEffect(Unit) {
                navHostController.popBackStack(Graph.AUTHENTICATION, inclusive = true)
                navHostController.navigate(route = Graph.HOME)
            }
        }

        is Response.Failure<*> -> {
            Toast.makeText(
                LocalContext.current,
                signupResponse.exception?.message ?: "Error desconocido",
                Toast.LENGTH_LONG
            ).show()
        }

        null -> {}
    }
}