package com.albanda.playandrate.presentation.screens.update_post.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.albanda.playandrate.R
import com.albanda.playandrate.presentation.components.DefaultTextFiled
import com.albanda.playandrate.presentation.components.DialogCapturePicture
import com.albanda.playandrate.presentation.screens.update_post.UpdatePostViewModel
import com.albanda.playandrate.presentation.ui.theme.Red500

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UpdatePostContent(updatePostViewModel: UpdatePostViewModel = hiltViewModel()) {

    val state = updatePostViewModel.state
    updatePostViewModel.resultingActivityHandler.handle()
    val dialogState = remember { mutableStateOf(false) }

    DialogCapturePicture(
        status = dialogState,
        takePhoto = { updatePostViewModel.takePhoto() },
        pickImage = { updatePostViewModel.pickImage() }
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Red500)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(32.dp))

                    val image = updatePostViewModel.state.image

                    if (image != "") {
                        AsyncImage(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .fillMaxWidth()
                                .height(200.dp)
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
                                .padding(top = 20.dp)
                                .height(120.dp)
                                .clickable {
                                    dialogState.value = true
                                },
                            painter = painterResource(id = R.drawable.add_image),
                            contentDescription = "User image"
                        )
                        Text(
                            text = "SELECCIONA UNA IMAGEN",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }


                }
            }
        }
        DefaultTextFiled(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp, start = 20.dp, end = 20.dp),
            value = state.name,
            onValueChange = { updatePostViewModel.onNameInput(it) },
            label = "Nombre del juego",
            leadingIcon = Icons.Default.Face,
            errorMsg = "",
            validateField = {
                ""
            }
        )
        DefaultTextFiled(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 20.dp, end = 20.dp),
            value = state.description,
            onValueChange = { updatePostViewModel.onDescriptionInput(it) },
            label = "Descripción",
            leadingIcon = Icons.AutoMirrored.Default.List,
            errorMsg = "",
            validateField = {
                ""
            }
        )
        Text(
            modifier = Modifier.padding(vertical = 15.dp),
            text = "CATEGORIAS",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
        updatePostViewModel.radioOptions.forEach { option ->
            Row(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .selectable(
                        selected = (option.category == state.category),
                        onClick = { updatePostViewModel.onCategoryInput(option.category) }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (option.category == state.category),
                    onClick = { updatePostViewModel.onCategoryInput(option.category) }
                )
                Text(
                    modifier = Modifier.width(120.dp),
                    text = option.category
                )
                Image(
                    modifier = Modifier
                        .height(50.dp)
                        .padding(8.dp),
                    painter = painterResource(id = option.image),
                    contentDescription = ""
                )
            }
        }
    }
}

/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewNewPostContent() {
    playandrateTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CreatePostContent()
        }
    }
}
*/