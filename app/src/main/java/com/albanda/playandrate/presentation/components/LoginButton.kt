package com.albanda.playandrate.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albanda.playandrate.presentation.ui.theme.Orange500
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Regular

@Composable
fun LoginButton(
    enable: Boolean = true,
    onClick: () -> Unit
) {
    Column() {
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Orange500),
            shape = RoundedCornerShape(12.dp),
            enabled = enable,
            onClick = { onClick() }
        ) {
            Text(
                text = "Iniciar sesión",
                color = Color.White,
                fontFamily = Orbitron_Regular,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginButton() {
    LoginButton(onClick = {})
}