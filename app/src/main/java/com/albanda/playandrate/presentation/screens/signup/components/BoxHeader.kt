package com.albanda.playandrate.presentation.screens.signup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.albanda.playandrate.R
import com.albanda.playandrate.presentation.ui.theme.Red500

@Composable
fun BoxHeader() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)
        .background(Red500)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(64.dp))
            Image(
                modifier = Modifier.height(120.dp),
                painter = painterResource(id = R.drawable.user),
                contentDescription = "User image"
            )
        }
    }
}