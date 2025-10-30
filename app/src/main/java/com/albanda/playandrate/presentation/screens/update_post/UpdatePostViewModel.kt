package com.albanda.playandrate.presentation.screens.update_post

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
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
class UpdatePostViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    savedStateHandle: SavedStateHandle,
    private val postUseCases: PostUseCases,
    authUseCases: AuthUseCases
) : ViewModel() {

    var state by mutableStateOf(UpdatePostState())

    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    val data = savedStateHandle.get<String>("post")
    val post = Post.fromJson(data!!)

    var updatePostResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    val currentUser = authUseCases.getCurrentUser()

    val radioOptions = listOf(
        CategoryRadioButton("Pc", R.drawable.icon_pc),
        CategoryRadioButton("Ps4", R.drawable.icon_ps4),
        CategoryRadioButton("Xbox", R.drawable.icon_xbox),
        CategoryRadioButton("Nintendo", R.drawable.icon_nintendo),
        CategoryRadioButton("Mobile", R.drawable.icon_mobile)
    )

    init {
        state = state.copy(
            name = post.name,
            description = post.description,
            category = post.category,
            image = post.image
        )
    }

    fun updatePost(post: Post) = viewModelScope.launch {
        updatePostResponse = Response.Loading
        val result = postUseCases.updatePost(post, file)
        updatePostResponse = result
    }

    fun onUpdatePost() {
        val post = Post(
            id = post.id,
            name = state.name,
            description = state.description,
            category = state.category,
            image = state.image,
            userId = currentUser?.uid ?: "",
        )
        updatePost(post)
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
//        state = state.copy(
//            name = "",
//            description = "",
//            category = "",
//            image = ""
//        )
        updatePostResponse = null
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