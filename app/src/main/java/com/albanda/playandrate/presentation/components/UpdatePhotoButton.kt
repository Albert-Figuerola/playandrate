package com.albanda.playandrate.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albanda.playandrate.presentation.ui.theme.Orange500
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Bold
import com.albanda.playandrate.presentation.ui.theme.White

@Composable
fun UpdatePhotoButton(
    onClick: () -> Unit
) {
    Column() {
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = White),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Orange500),
            onClick = { onClick() }
        ) {
            Text(
                text = "Sube una foto de perfil",
                color = Color.Black,
                fontFamily = Orbitron_Bold,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUpdatePhotoButton() {
    UpdatePhotoButton(onClick = {})
}