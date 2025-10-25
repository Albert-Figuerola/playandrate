package com.albanda.playandrate.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.albanda.playandrate.R
import com.albanda.playandrate.presentation.components.DefaultButton
import com.albanda.playandrate.presentation.components.DefaultTextFiled
import com.albanda.playandrate.presentation.screens.detail_post.components.DetailPostContent
import com.albanda.playandrate.presentation.screens.login.LoginViewModel
import com.albanda.playandrate.presentation.screens.welcome.components.WelcomeContent
import com.albanda.playandrate.presentation.ui.theme.DarkGray500
import com.albanda.playandrate.presentation.ui.theme.PlayAndRateTheme
import com.albanda.playandrate.presentation.ui.theme.Red500

@Composable
fun LoginContent(
    loginViewModel: LoginViewModel = hiltViewModel()
) {

    val state = loginViewModel.state

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(Red500)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(32.dp))
                Image(
                    modifier = Modifier.height(130.dp),
                    painter = painterResource(id = R.drawable.control),
                    contentDescription = "Xbox controller 360"
                )
                Text(
                    text = "FIREBASE MVVM"
                )
            }
        }

        Card(
            modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 200.dp),
            colors = CardDefaults.cardColors(containerColor = DarkGray500)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(
                            top = 32.dp,
                            bottom = 0.dp,
                            start = 0.dp,
                            end = 0.dp
                        ),
                    text = "LOGIN",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Por favor, inicia sesión para continuar.",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                DefaultTextFiled(
                    modifier = Modifier.padding(top = 16.dp),
                    value = state.email,
                    onValueChange = { loginViewModel.onEmailInput(it) },
                    label = "Correo electrónico",
                    leadingIcon = Icons.Default.Email,
                    keyboardType = KeyboardType.Email,
                    errorMsg = loginViewModel.emailErrMsg,
                    validateField = {
                        loginViewModel.validateEmail()
                    }
                )

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
                            tint = Color.White
                        )
                    }
                }

                DefaultTextFiled(
                    modifier = Modifier.padding(top = 6.dp),
                    value = state.password,
                    onValueChange = { loginViewModel.onPasswordInput(it) },
                    label = "Password",
                    leadingIcon = Icons.Default.Lock,
                    trailingIcon = trailing,
                    hideText = hideText,
                    keyboardType = KeyboardType.Password,
                    errorMsg = loginViewModel.passwordErrMsg,
                    validateField = {
                        loginViewModel.validatePassword()
                    }
                )

                DefaultButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    onClick = {
                        loginViewModel.login()
                    },
                    text = "INICIAR SESIÓN",
                    enable = loginViewModel.isEnabledLoginButton
                )
            }
        }
    }

}