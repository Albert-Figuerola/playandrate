package com.albanda.playandrate.presentation.navigation

import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.albanda.playandrate.presentation.screens.my_posts.MyPostsScreen
import com.albanda.playandrate.presentation.screens.posts.PostsScreen
import com.albanda.playandrate.presentation.screens.profile.ProfileScreen

@Composable
fun HomeBottomBarNavGraph(navHostController: NavHostController) {
    Scaffold(
        bottomBar = { HomeBottomBar(navHostController) }
    ) { innerPadding ->

        NavHost(
            navController = navHostController,
            route = Graph.HOME,
            startDestination = HomeBottomBarScreen.Posts.route,
            modifier = Modifier.padding(
                start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
                end = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
                bottom = innerPadding.calculateBottomPadding()
            )

        ) {
            composable(route = HomeBottomBarScreen.Posts.route) {
                PostsScreen(navHostController)
            }

            composable(route = HomeBottomBarScreen.MyPosts.route) {
                MyPostsScreen(navHostController)
            }

            composable(route = HomeBottomBarScreen.Profile.route) {
                ProfileScreen(navHostController)
            }

            detailsNavGraph(navHostController)
        }
    }

}

sealed class HomeBottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Posts : HomeBottomBarScreen(
        route = "posts",
        title = "Posts",
        icon = Icons.AutoMirrored.Filled.List
    )

    object MyPosts : HomeBottomBarScreen(
        route = "my_posts",
        title = "My posts",
        icon = Icons.AutoMirrored.Filled.List
    )

    object Profile : HomeBottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}