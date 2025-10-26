package com.albanda.playandrate.presentation.screens.welcome

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.albanda.playandrate.presentation.screens.welcome.components.WelcomeContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(
    navHostController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = { },
        content =
            {
                WelcomeContent(navHostController)
            },
        bottomBar = { }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewWelcomeContent() {
    WelcomeContent(
        navHostController = NavHostController(LocalContext.current)
    )
}