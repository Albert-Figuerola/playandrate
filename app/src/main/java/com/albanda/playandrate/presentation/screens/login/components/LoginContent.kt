package com.albanda.playandrate.presentation.screens.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.albanda.playandrate.R
import com.albanda.playandrate.presentation.components.LoginButton
import com.albanda.playandrate.presentation.components.PasswordTextFiled
import com.albanda.playandrate.presentation.components.TextFiled
import com.albanda.playandrate.presentation.screens.login.LoginViewModel
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Medium

@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = hiltViewModel()
) {

    val state = loginViewModel.state

    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Iniciar sesión",
            color = Color.Black,
            fontFamily = Orbitron_Medium,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        TextFiled(
            modifier = Modifier
                .fillMaxWidth(),
            value = state.email,
            onValueChange = { loginViewModel.onEmailInput(it) },
            label = "Correo electrónico*",
            keyboardType = KeyboardType.Email,
            errorMsg = loginViewModel.emailErrMsg,
            validateField = {
                loginViewModel.validateEmail()
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        var hideText by remember { mutableStateOf(true) }
        val trailing: @Composable () -> Unit = {
            val image = if (hideText) {
                R.drawable.visibility_off
            } else {
                R.drawable.visibility
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
            onValueChange = { loginViewModel.onPasswordInput(it) },
            label = "Contraseña*",
            trailingIcon = trailing,
            hideText = hideText,
            keyboardType = KeyboardType.Password,
            errorMsg = loginViewModel.passwordErrMsg,
            validateField = {
                loginViewModel.validatePassword()
            }
        )

        Spacer(modifier = Modifier.height(60.dp))

        LoginButton(
            text ="Iniciar sesión",
            onClick = {
                loginViewModel.login()
            }
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginContent() {
    LoginContent()
}