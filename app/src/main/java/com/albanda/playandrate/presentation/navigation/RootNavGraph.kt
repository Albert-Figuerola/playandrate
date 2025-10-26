package com.albanda.playandrate.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.albanda.playandrate.presentation.screens.welcome.WelcomeScreen

@Composable
fun RootNavGraph(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navHostController = navHostController)
        composable(route = Graph.HOME) {
            WelcomeScreen()
        }
    }

}