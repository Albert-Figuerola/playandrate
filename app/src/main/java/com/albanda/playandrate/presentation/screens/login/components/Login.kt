package com.albanda.playandrate.presentation.screens.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.presentation.components.ProgressBar
import com.albanda.playandrate.presentation.navigation.Graph
import com.albanda.playandrate.presentation.screens.login.LoginViewModel

@Composable
fun Login(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navHostController: NavHostController
) {

    when (val loginResponse = loginViewModel.loginResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success<*> -> {
            LaunchedEffect(Unit) {
                navHostController.navigate(route = Graph.HOME) {
                    popUpTo(Graph.AUTHENTICATION) { inclusive = true }
                }
            }
        }

        is Response.Failure<*> -> {
            Toast.makeText(
                LocalContext.current,
                loginResponse.exception?.message ?: "Error desconocido",
                Toast.LENGTH_LONG
            ).show()
        }

        null -> {}
    }

}