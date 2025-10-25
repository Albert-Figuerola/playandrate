package com.albanda.playandrate.presentation.screens.profile.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.albanda.playandrate.R
import com.albanda.playandrate.presentation.MainActivity
import com.albanda.playandrate.presentation.components.DefaultButton
import com.albanda.playandrate.presentation.navigation.DetailsScreen
import com.albanda.playandrate.presentation.screens.profile.ProfileViewModel

@SuppressLint("ContextCastToActivity")
@Composable
fun ProfileContent(
    profileViewModel: ProfileViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val activity = LocalContext.current as? Activity

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                alpha = 0.6f,
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Profile background image"
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Bienvenido",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(55.dp))

                val imageUrl = profileViewModel.userData.image

                Log.i("ProfileContent", "Image: $imageUrl")

                if (imageUrl != "") {
                    AsyncImage(
                        modifier = Modifier
                            .size(115.dp)
                            .clip(CircleShape),
                        model = imageUrl,
                        contentDescription = "User image",
                        contentScale = ContentScale.Crop,
                        onLoading = { placeholder ->
                            Log.d("AsyncImage", "Loading image...")
                        },
                        onError = { error ->
                            Log.e("AsyncImage", "Error loading image: ${error.result.throwable.message}")
                        },
                        onSuccess = { success ->
                            Log.d("AsyncImage", "Image loaded successfully!")
                        }
                    )
                } else {
                    Image(
                        modifier = Modifier.size(115.dp),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "Profile background image"
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(55.dp))

        Text(
            text = profileViewModel.userData.username,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = profileViewModel.userData.email,
            fontSize = 15.sp,
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(20.dp))

        DefaultButton(
            modifier = Modifier.width(250.dp),
            text = "Editar datos",
            icon = Icons.Default.Edit,
            color = Color.White,
            colorContent = Color.Black,
            onClick = {
                navHostController.navigate(route = DetailsScreen.ProfileUpdate.passUser(profileViewModel.userData.toJson()))
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        DefaultButton(
            modifier = Modifier.width(250.dp),
            text = "Cerrar sesión",
            icon = Icons.AutoMirrored.Default.ExitToApp,
            onClick = {
                profileViewModel.logout()
                activity?.finish()
                activity?.startActivity(Intent(activity, MainActivity::class.java))
            }
        )
    }

}