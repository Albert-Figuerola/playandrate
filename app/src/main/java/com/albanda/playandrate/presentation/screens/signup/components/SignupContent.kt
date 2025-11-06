package com.albanda.playandrate.presentation.screens.signup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.albanda.playandrate.R
import com.albanda.playandrate.presentation.components.DialogCapturePicture
import com.albanda.playandrate.presentation.components.LoginButton
import com.albanda.playandrate.presentation.components.PasswordRepeatTextFiled
import com.albanda.playandrate.presentation.components.PasswordTextFiled
import com.albanda.playandrate.presentation.components.TextFiled
import com.albanda.playandrate.presentation.components.UpdatePhotoButton
import com.albanda.playandrate.presentation.screens.signup.SignupViewModel
import com.albanda.playandrate.presentation.ui.theme.Inter_Regular
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Medium
import com.albanda.playandrate.presentation.ui.theme.PlayAndRateTheme

@Composable
fun SignupContent(
    modifier: Modifier = Modifier,
    signupViewModel: SignupViewModel = hiltViewModel()
) {
    val state = signupViewModel.state

    signupViewModel.resultingActivityHandler.handle()
    val dialogState = remember { mutableStateOf(false) }

    DialogCapturePicture(
        status = dialogState,
        takePhoto = { signupViewModel.takePhoto() },
        pickImage = { signupViewModel.pickImage() }
    )

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Crea tu nueva cuenta",
            color = Color.Black,
            fontFamily = Orbitron_Medium,
            fontSize = 18.sp
        )

        Spacer(Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val image = signupViewModel.state.image

            if (image != "") {
                AsyncImage(
                    modifier = Modifier
                        .height(120.dp)
                        .width(120.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    model = image,
                    contentDescription = "Selected image"
                )
            } else {
                Image(
                    modifier = Modifier.height(100.dp),
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "User image"
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            UpdatePhotoButton(
                onClick = { dialogState.value = true }
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        TextFiled(
            modifier = Modifier
                .fillMaxWidth(),
            value = state.username,
            onValueChange = { signupViewModel.onUsernameInput(it)  },
            label = "Nombre y apellido*",
            keyboardType = KeyboardType.Email,
            errorMsg = signupViewModel.usernameErrMsg,
            validateField = { signupViewModel.validateUsername() }
        )

        TextFiled(
            modifier = Modifier
                .fillMaxWidth(),
            value = state.alias,
            onValueChange = { signupViewModel.onAliasInput(it)  },
            label = "Alias*",
            keyboardType = KeyboardType.Email,
            errorMsg = signupViewModel.aliasErrMsg,
            validateField = { signupViewModel.validateAlias() }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Inicio de sesión",
            color = Color.Black,
            fontFamily = Orbitron_Medium,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextFiled(
            modifier = Modifier
                .fillMaxWidth(),
            value = state.email,
            onValueChange = { signupViewModel.onEmailInput(it)  },
            label = "email*",
            keyboardType = KeyboardType.Email,
            errorMsg = signupViewModel.emailErrMsg,
            validateField = { signupViewModel.validateEmail() }
        )

        var hideText by remember { mutableStateOf(true) }
        val trailing: @Composable () -> Unit = {
            val image = if (hideText) {
                R.drawable.icon_eye_closed
            } else {
                R.drawable.icon_eye_open
            }

            IconButton(onClick = { hideText = !hideText }) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    tint = Color.Gray
                )
            }
        }

        PasswordTextFiled(
            modifier = Modifier
                .fillMaxWidth(),
            value = state.password,
            onValueChange = { signupViewModel.onPasswordInput(it)  },
            label = "Contraseña*",
            trailingIcon = trailing,
            hideText = hideText,
            keyboardType = KeyboardType.Password,
            errorMsg = signupViewModel.passwordErrMsg,
            validateField = { signupViewModel.validatePassword() }
        )

        var hideTextPass by remember { mutableStateOf(true) }
        val trailingPass: @Composable () -> Unit = {
            val image = if (hideTextPass) {
                R.drawable.icon_eye_closed
            } else {
                R.drawable.icon_eye_open
            }

            IconButton(onClick = { hideTextPass = !hideTextPass }) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    tint = Color.Gray
                )
            }
        }

        PasswordRepeatTextFiled(
            modifier = Modifier
                .fillMaxWidth(),
            value = state.confirmPassword,
            onValueChange = { signupViewModel.onConfirmPasswordInput(it)  },
            label = "Repetir contraseña*",
            trailingIcon = trailingPass,
            hideText = hideTextPass,
            keyboardType = KeyboardType.Password,
            errorMsg = signupViewModel.confirmPasswordErrMsg,
            validateField = { signupViewModel.validateConfirmPassword() }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Elige una contraseña que contenga al menos: 8 caracteres, una mayúscula, una minúscula, un número y un caracter especial.",
            color = Color.Black,
            fontFamily = Inter_Regular,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(50.dp))

        LoginButton(
            text = "Crear cuenta",
            onClick = {
                signupViewModel.onSignup()
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewSignupContent() {
    PlayAndRateTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SignupContent()
        }
    }
}
