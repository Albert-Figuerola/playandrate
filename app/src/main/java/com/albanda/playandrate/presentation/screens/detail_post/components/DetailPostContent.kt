package com.albanda.playandrate.presentation.screens.detail_post.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.albanda.playandrate.R
import com.albanda.playandrate.presentation.screens.detail_post.DetailPostViewModel
import com.albanda.playandrate.presentation.ui.theme.PlayAndRateTheme
import com.albanda.playandrate.presentation.ui.theme.Red500

@Composable
fun DetailPostContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    detailPostViewModel: DetailPostViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Box() {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                model = detailPostViewModel.post.image,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            IconButton(onClick = { navHostController.popBackStack() }) {
                Icon(
                    modifier = Modifier
                        .size(35.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }

        if (!detailPostViewModel.post.user?.username.isNullOrBlank()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 20.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 15.dp)
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(55.dp)
                            .clip(CircleShape),
                        model = detailPostViewModel.post.user?.image ?: "",
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier.padding(top = 3.dp, start = 10.dp)
                    ) {
                        Text(
                            text = detailPostViewModel.post.user?.username ?: "",
                            fontSize = 13.sp
                        )
                        Text(
                            text = detailPostViewModel.post.user?.email ?: "",
                            fontSize = 11.sp
                        )
                    }
                }
            }
        } else {
            Spacer(modifier = Modifier.height(15.dp))
        }

        Text(
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 20.dp),
            text = detailPostViewModel.post.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Red500
        )

        Card(
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 20.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 7.dp, horizontal = 15.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(
                        when (detailPostViewModel.post.category) {
                            "Pc" -> {
                                R.drawable.icon_pc
                            }

                            "Ps4" -> {
                                R.drawable.icon_ps4
                            }

                            "Xbox" -> {
                                R.drawable.icon_xbox
                            }

                            "Nintendo" -> {
                                R.drawable.icon_nintendo
                            }

                            else -> {
                                R.drawable.icon_mobile
                            }
                        }
                    ),
                    contentDescription = ""
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = detailPostViewModel.post.category,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 15.dp, horizontal = 20.dp),
            thickness = 1.dp,
            color = Color.Gray
        )

        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Descripción",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )

        Text(
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp),
            text = detailPostViewModel.post.description,
            fontSize = 14.sp
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetailPostContentScreen() {
    PlayAndRateTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DetailPostContent(modifier = Modifier,rememberNavController())
        }
    }
}