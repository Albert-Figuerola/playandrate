package com.albanda.playandrate.presentation.screens.signup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albanda.playandrate.R
import com.albanda.playandrate.presentation.components.LoginButton
import com.albanda.playandrate.presentation.components.PasswordRepeatTextFiled
import com.albanda.playandrate.presentation.components.PasswordTextFiled
import com.albanda.playandrate.presentation.components.TextFiled
import com.albanda.playandrate.presentation.components.UpdatePhotoButton
import com.albanda.playandrate.presentation.ui.theme.Inter_Regular
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Medium
import com.albanda.playandrate.presentation.ui.theme.PlayAndRateTheme

@Composable
fun SignupContent(
    modifier: Modifier = Modifier,
) {
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
            Image(
                modifier = Modifier.height(100.dp),
                painter = painterResource(id = R.drawable.user),
                contentDescription = "User image"
            )

            Spacer(modifier = Modifier.height(10.dp))

            UpdatePhotoButton(
                onClick = { }
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        TextFiled(
            modifier = Modifier
                .fillMaxWidth(),
            value = "",
            onValueChange = {  },
            label = "Nombre y apellido*",
            keyboardType = KeyboardType.Email,
            errorMsg = "",
            validateField = {

            }
        )

        TextFiled(
            modifier = Modifier
                .fillMaxWidth(),
            value = "",
            onValueChange = {  },
            label = "Alias*",
            keyboardType = KeyboardType.Email,
            errorMsg = "",
            validateField = {

            }
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
            value = "",
            onValueChange = {  },
            label = "email*",
            keyboardType = KeyboardType.Email,
            errorMsg = "",
            validateField = { }
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
                    tint = Color.Gray
                )
            }
        }

        PasswordTextFiled(
            modifier = Modifier
                .fillMaxWidth(),
            value = "",
            onValueChange = {  },
            label = "Contraseña*",
            trailingIcon = trailing,
            hideText = hideText,
            keyboardType = KeyboardType.Email,
            errorMsg = "",
            validateField = {

            }
        )

        var hideTextPass by remember { mutableStateOf(true) }
        val trailingPass: @Composable () -> Unit = {
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

        PasswordRepeatTextFiled(
            modifier = Modifier
                .fillMaxWidth(),
            value = "",
            onValueChange = {  },
            label = "Repetir contraseña*",
            trailingIcon = trailingPass,
            hideText = hideTextPass,
            keyboardType = KeyboardType.Email,
            errorMsg = "",
            validateField = {

            }
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

            }
        )

//            CardForm()
        
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
