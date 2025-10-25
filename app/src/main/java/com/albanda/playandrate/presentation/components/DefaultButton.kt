package com.albanda.playandrate.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.albanda.playandrate.presentation.ui.theme.Red500

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    colorContent: Color? = null,
    onClick: () -> Unit,
    color: Color = Red500,
    icon: ImageVector = Icons.AutoMirrored.Filled.ArrowForward,
    enable: Boolean = true,
) {
    Column() {
        Button(
            modifier = modifier,
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(containerColor = color),
            enabled = enable,
        ) {
            Icon(
                tint = colorContent ?: Color.White,
                imageVector = icon,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                color = colorContent ?: Color.White,
                text = text
            )
        }
    }
}