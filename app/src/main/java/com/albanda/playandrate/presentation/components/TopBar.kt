package com.albanda.playandrate.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.albanda.playandrate.presentation.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String?,
    upAvailable: Boolean = false,
    navHostController: NavHostController? = null
) {
    TopAppBar(
        title = {
            if (title != null) {
                Text(
                    text = title,
                    fontSize = 18.sp
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = White),
        navigationIcon = {
            if (upAvailable) {
                IconButton(
                    onClick = { navHostController?.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTopBar() {
    TopBar(title = "Preview", upAvailable = true,)
}

