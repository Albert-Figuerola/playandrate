package com.albanda.playandrate.presentation.screens.welcome

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.albanda.playandrate.presentation.screens.welcome.components.WelcomeContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(
    navHostController: NavHostController
) {
    Scaffold(
        topBar =
            {},
        content =
            {
                WelcomeContent()
            },
        bottomBar =
            {

            }
    )
}