package com.albanda.playandrate.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.albanda.playandrate.presentation.screens.home.HomeScreen

@Composable
fun RootNavGraph(
    navHostController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = startDestination
    ) {
        authNavGraph(navHostController = navHostController)
        composable(route = Graph.HOME) {
            // Home
            HomeScreen()
        }
    }
}
