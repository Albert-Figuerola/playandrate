package com.albanda.playandrate.presentation.screens.posts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.albanda.playandrate.presentation.ui.theme.GrayCard
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Bold
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Medium
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Regular

@Composable
fun PostsCard(
    navHostController: NavHostController,
    post: Post,
    viewModel: GetPostsViewModel = hiltViewModel()
) {
    val currentUserId = viewModel.currentUser?.uid ?: ""
    val userImage = post.user?.image ?: R.drawable.icon_user_man_default

    Card(
        modifier = Modifier
            .padding(top = 12.dp)
            .clickable {
                navHostController.navigate(route = DetailsScreen.DetailPost.passPost(post.toJson()))
            },
//        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = GrayCard),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop,
                    model = userImage,
                    contentDescription = "User image"
                )

                Column {
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = post.user?.alias ?: "",
                        fontFamily = Orbitron_Medium,
                        fontSize = 14.sp
                    )

                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = post.createdAt,
                        fontFamily = Orbitron_Regular,
                        fontSize = 10.sp
                    )
                }
            }

            AsyncImage(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(),
                model = post.image,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                text = post.name,
                fontFamily = Orbitron_Bold,
                fontSize = 18.sp
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
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 0..3) {
                    Image(
                        modifier = Modifier
                            .size(20.dp),
                        painter = painterResource(id = R.drawable.icon_star_solid_orange),
                        contentDescription = "Like icon",
                    )
                }
                Image(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.icon_star_orange),
                    contentDescription = "Like icon",
                )

                Spacer(modifier = Modifier.weight(1f))

                if (post.likes.contains(currentUserId)) {
                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                viewModel.deleteLike(post.id, currentUserId)
                            },
                        painter = painterResource(id = R.drawable.icon_heart_solid_orange),
                        contentDescription = "Like icon",
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                viewModel.like(post.id, currentUserId)
                            },
                        painter = painterResource(id = R.drawable.icon_heart_orange),
                        contentDescription = "Like icon",
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = post.likes.size.toString(),
                    fontFamily = Orbitron_Medium,
                    fontSize = 14.sp
                )
            }
        }
    }
}

