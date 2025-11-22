package com.albanda.playandrate.presentation.screens.my_posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albanda.playandrate.data.room.dao.UserDao
import com.albanda.playandrate.domain.mapper.user.toUser
import com.albanda.playandrate.domain.model.Post
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.domain.model.User
import com.albanda.playandrate.domain.usecase.auth.AuthUseCases
import com.albanda.playandrate.domain.usecase.post.PostUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPostsViewModel @Inject constructor(
    private val postUseCases: PostUseCases,
    private val authUseCases: AuthUseCases,
    private val userDao: UserDao
): ViewModel() {

    var postsResponse by mutableStateOf<Response<List<Post>>?>(null)
    var deleteResponse by mutableStateOf<Response<Boolean>?>(null)
    val currentUser = authUseCases.getCurrentUser()

    var user by mutableStateOf<User?>(null)

    init {
        getPosts()
        viewModelScope.launch {
            val userEntity = userDao.getUser()
            if (userEntity != null) {
                user = userEntity.toUser()
            }
        }
    }

    fun deletePost(postId: String) = viewModelScope.launch {
        deleteResponse = Response.Loading
        val result = postUseCases.deletePost(postId)
        deleteResponse = result
    }

    fun getPosts() = viewModelScope.launch {
        postsResponse = Response.Loading
        postUseCases.getPostsByUserId(currentUser?.uid ?: "").collect() { response ->
            postsResponse = response
        }
    }

}
