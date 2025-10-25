package com.albanda.playandrate.presentation.screens.profile_update

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.albanda.playandrate.presentation.components.DefaultTopBar
import com.albanda.playandrate.presentation.screens.profile_update.components.ProfileUpdateContent
import com.albanda.playandrate.presentation.screens.profile_update.components.ProfileUpdate
import com.albanda.playandrate.presentation.screens.profile_update.components.SaveImage

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileEditScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Editar perfil",
                upAvailable = true,
                navHostController = navHostController
            )
        },
        content = {
            ProfileUpdateContent()
        },
        bottomBar = {}
    )
    SaveImage()
    ProfileUpdate()
}