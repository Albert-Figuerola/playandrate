package com.albanda.playandrate.presentation.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.albanda.playandrate.presentation.components.TopBar
import com.albanda.playandrate.presentation.screens.login.components.Login
import com.albanda.playandrate.presentation.screens.login.components.LoginContent
import com.albanda.playandrate.presentation.ui.theme.PlayAndRateTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navHostController: NavHostController) {

    Scaffold(
        topBar = {
            TopBar(
                title = null,
                upAvailable = true,
                navHostController = navHostController
            )
        },
        content = { innerPadding ->
            LoginContent(modifier = Modifier.padding(innerPadding))
        },
        bottomBar = { }
    )
    Login(navHostController = navHostController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    PlayAndRateTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(rememberNavController())
        }
    }
}