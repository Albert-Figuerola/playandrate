package com.albanda.playandrate.presentation.screens.create_post

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albanda.playandrate.presentation.utils.ComposeFileProvider
import com.albanda.playandrate.R
import com.albanda.playandrate.domain.model.Post
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.domain.usecase.auth.AuthUseCases
import com.albanda.playandrate.domain.usecase.post.PostUseCases
import com.albanda.playandrate.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class CreatePostViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val postUseCases: PostUseCases,
    private val authUseCases: AuthUseCases
): ViewModel() {

    var state by mutableStateOf(CreatePostState())

    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    var createPostResponse by mutableStateOf<Response<Boolean>?>(null)
            private set

    val currentUser = authUseCases.getCurrentUser()

    val radioOptions = listOf(
        CategoryRadioButton("Pc", R.drawable.icon_pc),
        CategoryRadioButton("Ps4", R.drawable.icon_ps4),
        CategoryRadioButton("Xbox", R.drawable.icon_xbox),
        CategoryRadioButton("Nintendo", R.drawable.icon_nintendo),
        CategoryRadioButton("Mobile", R.drawable.icon_mobile)
    )

    fun createPost(post: Post) = viewModelScope.launch {
        createPostResponse = Response.Loading
        val result = postUseCases.createPost(post, file!!)
        createPostResponse = result
    }

    fun onCreatePost() {
        val post = Post(
            name = state.name,
            description = state.description,
            category = state.category,
            userId = currentUser?.uid ?: "",
        )
        createPost(post)
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
    }

    fun clearForm() {
        state = state.copy(
            name = "",
            description = "",
            category = "",
            image = ""
        )
        createPostResponse = null
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onDescriptionInput(description: String) {
        state = state.copy(description = description)
    }

    fun onCategoryInput(category: String) {
        state = state.copy(category = category)
    }

}

data class CategoryRadioButton(
    var category: String,
    var image: Int
)