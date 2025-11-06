package com.albanda.playandrate.presentation.screens.posts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.albanda.playandrate.R
import com.albanda.playandrate.domain.model.Post
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Medium

@Composable
fun PostsContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    posts: List<Post>
) {
    val postsCount = posts.size

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .padding(bottom = 20.dp),
            painter = painterResource(id = R.drawable.play_and_rate_logo),
            contentDescription = "Logo"
        )

        Text(
            text = "Artículos $postsCount",
            color = Color.Black,
            fontFamily = Orbitron_Medium,
            fontSize = 18.sp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(
                items = posts
            ) { post ->
                PostsCard(navHostController = navHostController, post = post)
            }
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPostsContent() {
    PostsContent(
        modifier = Modifier,
        navHostController = NavHostController(LocalContext.current),
        listOf()
    )
}