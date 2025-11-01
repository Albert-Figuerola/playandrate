package com.albanda.playandrate.presentation.screens.signup

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albanda.playandrate.presentation.utils.ComposeFileProvider
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.domain.model.User
import com.albanda.playandrate.domain.usecase.auth.AuthUseCases
import com.albanda.playandrate.domain.usecase.user.UserUseCases
import com.albanda.playandrate.presentation.screens.utils.AuthFormValidator
import com.albanda.playandrate.presentation.utils.ResultingActivityHandler
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import id.zelory.compressor.Compressor
import id.zelory.compressor.constraint.default
import jakarta.inject.Inject
import kotlinx.coroutines.launch
import java.io.File

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val userUseCases: UserUseCases,
    @ApplicationContext private val context: Context
) : ViewModel() {
    var state by mutableStateOf(SignupState())
        private set

    var isUsernameValid by mutableStateOf(false)
        private set
    var usernameErrMsg by mutableStateOf("")
        private set

    var isAliasValid by mutableStateOf(false)
        private set
    var aliasErrMsg by mutableStateOf("")
        private set

    var isEmailValid by mutableStateOf(false)
        private set
    var emailErrMsg by mutableStateOf("")
        private set

    var isPasswordValid by mutableStateOf(false)
        private set
    var passwordErrMsg by mutableStateOf("")
        private set

    var isConfirmPasswordValid by mutableStateOf(false)
        private set
    var confirmPasswordErrMsg by mutableStateOf("")
        private set

    var saveImageResponse by mutableStateOf<Response<String>?>(null)
        private set

    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    var isEnabledLoginButton = false

    var signupResponse by mutableStateOf<Response<FirebaseUser>?>(null)
        private set

    var user = User()

    fun onUsernameInput(username: String) {
        state = state.copy(username = username)
    }

    fun onAliasInput(alias: String) {
        state = state.copy(alias = alias)
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String) {
        state = state.copy(confirmPassword = confirmPassword)
    }

    fun validateUsername() {
        isUsernameValid = AuthFormValidator.isUsernameValid(state.username)
        usernameErrMsg = if (isUsernameValid) "" else "Almenos 5 caracteres"

        enabledSignupButton()
    }

    fun validateAlias() {
        isAliasValid = AuthFormValidator.isUsernameValid(state.alias)
        aliasErrMsg = if (isAliasValid) "" else "Almenos 5 caracteres"

        enabledSignupButton()
    }

    fun validateEmail() {
        isEmailValid = AuthFormValidator.isEmailValid(state.email)
        emailErrMsg = if (isEmailValid) "" else "El correo electrónico no es válido"

        enabledSignupButton()
    }

    fun validatePassword() {
        isPasswordValid = AuthFormValidator.isPasswordValid(state.password)
        passwordErrMsg = if (isPasswordValid) "" else "Al menos 6 caracteres"

        enabledSignupButton()
    }

    fun validateConfirmPassword() {
        isConfirmPasswordValid =
            AuthFormValidator.isConfirmPasswordValid(state.password, state.confirmPassword)
        confirmPasswordErrMsg =
            if (isConfirmPasswordValid) "" else "Las contraseñas no coinciden"

        enabledSignupButton()
    }

    fun enabledSignupButton() {
        isEnabledLoginButton = isEmailValid &&
                isPasswordValid &&
                isUsernameValid &&
                isConfirmPasswordValid
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

    fun onSignup() {
        user.email = state.email
        user.password = state.password

        signup(user)
    }

    fun signup(user: User) = viewModelScope.launch {
        signupResponse = Response.Loading
        val authResult = authUseCases.signup(user)

        if (authResult is Response.Success) {
            try {
                val imageUrl = saveImage()

                createUser(user, imageUrl)

                signupResponse = authResult
            } catch (e: Exception) {
                Log.e("Signup", "Error en flujo de registro: ${e.message}")
                signupResponse = Response.Failure(e)
            }
        }
    }

    suspend fun saveImage(): String? {
        if (file == null) {
            Log.w("Signup", "No hay archivo para subir")
            return null
        }

        saveImageResponse = Response.Loading

        return try {
            val compressedFile = Compressor.compress(context, file!!) {
                default(width = 800, format = Bitmap.CompressFormat.JPEG, quality = 70)
            }

            Log.i("Signup", "Imagen comprimida: ${compressedFile.length() / 1024} KB")

            val result = userUseCases.saveImage(compressedFile)
            saveImageResponse = result

            when (result) {
                is Response.Success -> result.data
                is Response.Failure -> {
                    Log.e("Signup", "Error subiendo imagen: ${result.exception}")
                    null
                }
                else -> null
            }
        } catch (e: Exception) {
            Log.e("Signup", "Error al comprimir/subir imagen: ${e.message}")
            e.printStackTrace()
            null
        }
    }

    suspend fun createUser(user: User, imageUrl: String?) {
        user.id = authUseCases.getCurrentUser()!!.uid
        user.username = state.username
        user.alias = state.alias
        user.email = state.email
        user.password = ""
        user.image = imageUrl ?: ""

        userUseCases.createUser(user)
    }

}