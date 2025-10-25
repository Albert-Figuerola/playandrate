package com.albanda.playandrate.presentation.screens.posts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.albanda.playandrate.domain.model.Post
import com.albanda.playandrate.R
import com.albanda.playandrate.presentation.navigation.DetailsScreen
import com.albanda.playandrate.presentation.screens.posts.GetPostsViewModel

@Composable
fun PostsCard(
    navHostController: NavHostController,
    post: Post,
    viewModel: GetPostsViewModel = hiltViewModel()
) {
    val currentUserId = viewModel.currentUser?.uid ?: ""

    Card(
        modifier = Modifier
            .padding(top = 12.dp)
            .clickable {
                navHostController.navigate(route = DetailsScreen.DetailPost.passPost(post.toJson()))
            },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column() {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                model = post.image,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                text = post.name,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = post.user?.username ?: "Anonymous",
                fontSize = 13.sp
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = post.description,
                fontSize = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray
            )
            Row(
                modifier = Modifier.padding(start = 15.dp, bottom = 15.dp)
            ) {
                if (post.likes.contains(currentUserId)) {
                    Image(
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                viewModel.deleteLike(post.id, currentUserId)
                            },
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "Like icon",
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                viewModel.like(post.id, currentUserId)
                            },
                        painter = painterResource(id = R.drawable.like_outline),
                        contentDescription = "Like icon",
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = post.likes.size.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            }
        }
    }
}

