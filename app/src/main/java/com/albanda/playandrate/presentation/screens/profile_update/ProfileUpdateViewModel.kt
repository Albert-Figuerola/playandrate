package com.albanda.playandrate.presentation.screens.profile_update

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albanda.playandrate.presentation.utils.ComposeFileProvider
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.domain.model.User
import com.albanda.playandrate.domain.usecase.user.UserUseCases
import com.albanda.playandrate.presentation.screens.utils.AuthFormValidator
import com.albanda.playandrate.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import kotlinx.coroutines.launch
import java.io.File

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    saveStateHandle: SavedStateHandle,
    private val userUseCases: UserUseCases,
    @ApplicationContext private val context: Context
) : ViewModel() {
    var state by mutableStateOf(ProfileUpdateState())
        private set

    var isUsernameValid by mutableStateOf(false)
        private set
    var usernameErrMsg by mutableStateOf("")
        private set

    var data = saveStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    var updateResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    var saveImageResponse by mutableStateOf<Response<String>?>(null)
        private set

    var file: File? = null

    val resultingActivityHandler = ResultingActivityHandler()

    init {
        state = state.copy(
            username = user.username,
            image = user.image
        )
    }

    fun saveImage() = viewModelScope.launch {
        if (file != null) {
            saveImageResponse = Response.Loading
            val result = userUseCases.saveImage(file!!)
            saveImageResponse = result
        }
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

    fun onUpdate(url: String) {
        val myUser = User(
            id = user.id,
            username = state.username,
            image = url
        )
        updateUser(myUser)
    }

    fun updateUser(user: User) = viewModelScope.launch {
        updateResponse = Response.Loading
        val result = userUseCases.updateUser(user)
        updateResponse = result
    }

    fun onUsernameInput(username: String) {
        state = state.copy(username = username)
    }

    fun validateUsername() {
        isUsernameValid = AuthFormValidator.isUsernameValid(state.username)
        usernameErrMsg = if (isUsernameValid) "" else "Almenos 5 caracteres"
    }

}