package com.albanda.playandrate.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.albanda.playandrate.presentation.screens.create_post.CreatePostScreen
import com.albanda.playandrate.presentation.screens.detail_post.DetailPostScreen
import com.albanda.playandrate.presentation.screens.profile_update.ProfileEditScreen
import com.albanda.playandrate.presentation.screens.update_post.UpdatePostScreen

fun NavGraphBuilder.detailsNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.ProfileUpdate.route
    ) {
//        composable(route = DetailsScreen.Login.route) {
//            LoginScreen(navHostController)
//        }

        composable(route = DetailsScreen.CreatePost.route) {
            CreatePostScreen(navHostController)
        }

        composable(route = DetailsScreen.CreatePost.route) {
            CreatePostScreen(navHostController)
        }

        composable(
            route = DetailsScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                ProfileEditScreen(navHostController)
            }
        }

        composable(
            route = DetailsScreen.DetailPost.route,
            arguments = listOf(navArgument("post") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("post")?.let { post ->
                DetailPostScreen(navHostController, post = post)
            }
        }

        composable(
            route = DetailsScreen.UpdatePost.route,
            arguments = listOf(navArgument("post") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("post")?.let { post ->
                UpdatePostScreen(navHostController)
            }
        }

    }
}

sealed class DetailsScreen(val route: String) {
//    object Login: DetailsScreen("login")
    object CreatePost: DetailsScreen("post/new")
    object ProfileUpdate: DetailsScreen("profile/edit/{user}") {
        fun passUser(user: String) = "profile/edit/$user"
    }
    object DetailPost: DetailsScreen("posts/detail/{post}") {
        fun passPost(post: String) = "posts/detail/$post"
    }
    object UpdatePost: DetailsScreen("posts/update/{post}") {
        fun passPost(post: String) = "posts/update/$post"
    }
}