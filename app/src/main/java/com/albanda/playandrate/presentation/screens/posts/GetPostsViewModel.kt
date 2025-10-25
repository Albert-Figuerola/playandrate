package com.albanda.playandrate.presentation.screens.posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albanda.playandrate.domain.model.Post
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.domain.usecase.auth.AuthUseCases
import com.albanda.playandrate.domain.usecase.post.PostUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetPostsViewModel @Inject constructor(
    private val postUseCases: PostUseCases,
    authUseCases: AuthUseCases
): ViewModel() {

    var postsResponse by mutableStateOf<Response<List<Post>>?>(null)

    var likeResponse by mutableStateOf<Response<Boolean>?>(null)
    var deleteLikeResponse by mutableStateOf<Response<Boolean>?>(null)

    var currentUser = authUseCases.getCurrentUser()

    init {
        getPosts()
    }

    fun like(postId: String, userId: String) = viewModelScope.launch {
        likeResponse = Response.Loading
        val result = postUseCases.createLikePost(postId, userId)
        likeResponse = result
    }

    fun deleteLike(postId: String, userId: String) = viewModelScope.launch {
        deleteLikeResponse = Response.Loading
        val result = postUseCases.deleteLikePost(postId, userId)
        deleteLikeResponse = result
    }

    fun getPosts() = viewModelScope.launch {
        postsResponse = Response.Loading
        postUseCases.getPosts().collect() { response ->
            postsResponse = response
        }
    }

}