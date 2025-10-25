package com.albanda.playandrate.presentation.screens.detail_post

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.albanda.playandrate.domain.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class DetailPostViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val data = savedStateHandle.get<String>("post")
    val post = Post.fromJson(data!!)

}