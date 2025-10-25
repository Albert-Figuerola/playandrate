package com.albanda.playandrate.presentation.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albanda.playandrate.domain.model.Response
import com.albanda.playandrate.domain.usecase.auth.AuthUseCases
import com.albanda.playandrate.presentation.screens.utils.AuthFormValidator
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    var isEmailValid  by mutableStateOf(false)
        private set
    var emailErrMsg  by mutableStateOf("")
        private set

    var isPasswordValid  by mutableStateOf(false)
        private set
    var passwordErrMsg  by mutableStateOf("")
        private set

    var isEnabledLoginButton = false

    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null)

    val currentUser = authUseCases.getCurrentUser()

    init {
        if (currentUser != null) {
            loginResponse = Response.Success(currentUser)
        }
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun login() = viewModelScope.launch {
        loginResponse = Response.Loading
        val result = authUseCases.login(state.email, state.password)
        loginResponse = result
    }

    fun validateEmail() {
        isEmailValid = AuthFormValidator.isEmailValid(state.email)
        emailErrMsg = if (isEmailValid) "" else "El correo electrónico no es válido"

        enabledLoginButton()
    }

    fun validatePassword() {
        isPasswordValid = AuthFormValidator.isPasswordValid(state.password)
        passwordErrMsg = if (isPasswordValid) "" else "Al menos 6 caracteres"

        enabledLoginButton()
    }

    fun enabledLoginButton() {
        isEnabledLoginButton = isEmailValid && isPasswordValid
    }
}