package com.albanda.playandrate.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.albanda.playandrate.presentation.screens.login.LoginScreen
import com.albanda.playandrate.presentation.screens.signup.SignupScreen
import com.albanda.playandrate.presentation.screens.welcome.WelcomeScreen

fun NavGraphBuilder.authNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            WelcomeScreen(navHostController)
        }

        composable(route = AuthScreen.Signup.route) {
            SignupScreen(navHostController)
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login: AuthScreen("login")
    object Signup: AuthScreen("signup")
}