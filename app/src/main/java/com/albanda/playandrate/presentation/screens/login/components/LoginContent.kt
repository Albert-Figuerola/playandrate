package com.albanda.playandrate.presentation.screens.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albanda.playandrate.presentation.components.DefaultTextFiled
import com.albanda.playandrate.presentation.components.LoginButton
import com.albanda.playandrate.presentation.components.TextFiled
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Medium

@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
//    loginViewModel: LoginViewModel = hiltViewModel()
) {

//    val state = loginViewModel.state

    Column(
        modifier = modifier
            .padding(12.dp),
//        verticalArrangement = Arrangement.Top
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Iniciar sesión",
            color = Color.Black,
            fontFamily = Orbitron_Medium,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

//        TextFiled(
//            modifier = Modifier
//                .fillMaxWidth(),
//            value = "", //state.email,
//            onValueChange = {  }, // { loginViewModel.onEmailInput(it) },
//            label = "Correo electrónico*",
//            keyboardType = KeyboardType.Email,
//            errorMsg = "",  // loginViewModel.emailErrMsg,
//            validateField = {
//                //loginViewModel.validateEmail()
//            }
//        )

        DefaultTextFiled(
            modifier = Modifier.padding(top = 0.dp),
            value = "",
            onValueChange = {  },
            label = "Correo electrónico",
            leadingIcon = Icons.Default.Email,
            keyboardType = KeyboardType.Email,
            errorMsg = "",
            validateField = {  }
        )

        Spacer(modifier = Modifier.height(40.dp))

        LoginButton(
            onClick = {
//                loginViewModel.login()
//                navHostController.navigate(route = AuthScreen.Login.route)
            }
        )
    }

//    val state = loginViewModel.state
//
//    Box(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(250.dp)
//                .background(Red500)
//        ) {
//            Column(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Spacer(Modifier.height(32.dp))
//                Image(
//                    modifier = Modifier.height(130.dp),
//                    painter = painterResource(id = R.drawable.control),
//                    contentDescription = "Xbox controller 360"
//                )
//                Text(
//                    text = "FIREBASE MVVM"
//                )
//            }
//        }
//
//        Card(
//            modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 200.dp),
//            colors = CardDefaults.cardColors(containerColor = DarkGray500)
//        ) {
//            Column(
//                modifier = Modifier
//                    .padding(horizontal = 20.dp)
//            ) {
//                Text(
//                    modifier = Modifier
//                        .padding(
//                            top = 32.dp,
//                            bottom = 0.dp,
//                            start = 0.dp,
//                            end = 0.dp
//                        ),
//                    text = "LOGIN",
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = "Por favor, inicia sesión para continuar.",
//                    fontSize = 12.sp,
//                    color = Color.Gray
//                )
//
//                DefaultTextFiled(
//                    modifier = Modifier.padding(top = 16.dp),
//                    value = state.email,
//                    onValueChange = { loginViewModel.onEmailInput(it) },
//                    label = "Correo electrónico",
//                    leadingIcon = Icons.Default.Email,
//                    keyboardType = KeyboardType.Email,
//                    errorMsg = loginViewModel.emailErrMsg,
//                    validateField = {
//                        loginViewModel.validateEmail()
//                    }
//                )
//
//                var hideText by remember { mutableStateOf(true) }
//                val trailing: @Composable () -> Unit = {
//                    val image = if (hideText) {
//                        R.drawable.visibility_off
//                    } else {
//                        R.drawable.visibility
//                    }
//
//                    IconButton(onClick = { hideText = !hideText }) {
//                        Icon(
//                            painter = painterResource(id = image),
//                            contentDescription = "",
//                            tint = Color.White
//                        )
//                    }
//                }
//
//                DefaultTextFiled(
//                    modifier = Modifier.padding(top = 6.dp),
//                    value = state.password,
//                    onValueChange = { loginViewModel.onPasswordInput(it) },
//                    label = "Password",
//                    leadingIcon = Icons.Default.Lock,
//                    trailingIcon = trailing,
//                    hideText = hideText,
//                    keyboardType = KeyboardType.Password,
//                    errorMsg = loginViewModel.passwordErrMsg,
//                    validateField = {
//                        loginViewModel.validatePassword()
//                    }
//                )
//
//                DefaultButton(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 32.dp),
//                    onClick = {
//                        loginViewModel.login()
//                    },
//                    text = "INICIAR SESIÓN",
//                    enable = loginViewModel.isEnabledLoginButton
//                )
//            }
//        }
//    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginContent() {
    LoginContent()
}