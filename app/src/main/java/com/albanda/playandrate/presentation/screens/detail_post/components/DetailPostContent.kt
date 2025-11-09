package com.albanda.playandrate.presentation.screens.detail_post.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.albanda.playandrate.R
import com.albanda.playandrate.presentation.screens.detail_post.DetailPostViewModel
import com.albanda.playandrate.presentation.ui.theme.Inter_Regular
import com.albanda.playandrate.presentation.ui.theme.Orange500
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Bold
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Regular

@Composable
fun DetailPostContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    detailPostViewModel: DetailPostViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Box() {
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(),
                model = detailPostViewModel.post.image,
                contentDescription = "Game image",
                contentScale = ContentScale.Crop
            )
        }

//        if (!detailPostViewModel.post.user?.username.isNullOrBlank()) {
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 15.dp, horizontal = 20.dp),
//                elevation = CardDefaults.cardElevation(4.dp),
//                shape = RoundedCornerShape(10.dp)
//            ) {
//                Row(
//                    modifier = Modifier
//                        .padding(vertical = 10.dp, horizontal = 15.dp)
//                ) {
//                    AsyncImage(
//                        modifier = Modifier
//                            .size(55.dp)
//                            .clip(CircleShape),
//                        model = detailPostViewModel.post.user?.image ?: "",
//                        contentDescription = "",
//                        contentScale = ContentScale.Crop
//                    )
//                    Column(
//                        modifier = Modifier.padding(top = 3.dp, start = 10.dp)
//                    ) {
//                        Text(
//                            text = detailPostViewModel.post.user?.username ?: "",
//                            fontSize = 13.sp
//                        )
//                        Text(
//                            text = detailPostViewModel.post.user?.email ?: "",
//                            fontSize = 11.sp
//                        )
//                    }
//                }
//            }
//        } else {
//            Spacer(modifier = Modifier.height(15.dp))
//        }

        Text(
            modifier = Modifier
                .padding(top = 20.dp),
            text = detailPostViewModel.post.name,
            fontFamily = Orbitron_Bold,
            fontSize = 22.sp
        )

        Text(
            modifier = Modifier
                .padding(top = 10.dp),
            text = detailPostViewModel.post.user?.username ?: "",
            fontFamily = Orbitron_Bold,
            color = Orange500,
            fontSize = 16.sp
        )

        Text(
            text = detailPostViewModel.post.createdAt,
            fontFamily = Orbitron_Regular,
            fontSize = 12.sp
        )

        Card(
            modifier = Modifier
                .padding(top = 10.dp),
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

                Spacer(modifier = Modifier.width(20.dp))

                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = detailPostViewModel.post.category,
                        fontFamily = Orbitron_Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp),
            thickness = 1.dp,
            color = Color.Gray
        )

        Text(
            text = "Descripción",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = detailPostViewModel.post.description,
            fontFamily = Inter_Regular,
            fontSize = 14.sp
        )

    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PreviewDetailPostContentScreen() {
//    PlayAndRateTheme(darkTheme = true) {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            DetailPostContent(modifier = Modifier, rememberNavController())
//        }
//    }
//}