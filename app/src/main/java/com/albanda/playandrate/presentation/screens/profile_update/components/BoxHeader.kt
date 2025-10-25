package com.albanda.playandrate.presentation.screens.profile_update.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.albanda.playandrate.R
import com.albanda.playandrate.presentation.components.DialogCapturePicture
import com.albanda.playandrate.presentation.screens.profile_update.ProfileUpdateViewModel
import com.albanda.playandrate.presentation.ui.theme.Red500

@Composable
fun BoxHeader(profileUpdateViewModel: ProfileUpdateViewModel = hiltViewModel()) {

    profileUpdateViewModel.resultingActivityHandler.handle()
    val dialogState = remember { mutableStateOf(false) }

    DialogCapturePicture(
        status = dialogState,
        takePhoto = { profileUpdateViewModel.takePhoto() },
        pickImage = { profileUpdateViewModel.pickImage() }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(Red500)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(64.dp))

            val image = profileUpdateViewModel.state.image
            Log.i("BoxHeader", "Image: $image")

            if (image != "") {
                AsyncImage(
                    modifier = Modifier
                        .height(120.dp)
                        .width(120.dp)
                        .clip(CircleShape)
                        .clickable {
                            dialogState.value = true
                        },
                    contentScale = ContentScale.Crop,
                    model = image,
                    contentDescription = "Selected image"
                )
            } else {
                Image(
                    modifier = Modifier
                        .height(120.dp)
                        .clickable {
                            dialogState.value = true
                        },
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "User image"
                )
            }

        }
    }
}