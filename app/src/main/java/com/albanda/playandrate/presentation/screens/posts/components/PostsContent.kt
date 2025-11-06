package com.albanda.playandrate.presentation.screens.posts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.albanda.playandrate.R
import com.albanda.playandrate.domain.model.Post
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Medium

@Composable
fun PostsContent(
    navHostController: NavHostController,
    posts: List<Post>
) {
    val postsCount = posts.size

    Column(
        modifier = Modifier
            .padding(16.dp)
//            .fillMaxWidth()
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .height(140.dp),
            painter = painterResource(id = R.drawable.play_and_rate_logo),
            contentDescription = "Logo"
        )

        Text(
            text = "Artículos $postsCount",
            color = Color.Black,
            fontFamily = Orbitron_Medium,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
                .weight(1f)
        ) {
            items(
                items = posts
            ) { post ->
                PostsCard(navHostController = navHostController, post = post)
            }
        }
    }
}