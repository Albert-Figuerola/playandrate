package com.albanda.playandrate.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults.colors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albanda.playandrate.presentation.ui.theme.Inter_Regular
import com.albanda.playandrate.presentation.ui.theme.Orange500
import com.albanda.playandrate.presentation.ui.theme.Red700

@Composable
fun PasswordTextFiled(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    validateField: () -> Unit = {},
    label: String,
    trailingIcon: (@Composable (() -> Unit)),
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = true,
    errorMsg: String = ""
) {

    OutlinedTextField(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        value = value,
        onValueChange = {
            onValueChange(it)
            validateField()
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        label = {
            Text(
                text = label,
                fontFamily = Inter_Regular,
                fontSize = 14.sp
            )
        },
        colors = colors(
            focusedBorderColor = Orange500,
            unfocusedBorderColor = Color.Gray,
            cursorColor = Orange500,
            focusedLabelColor = Orange500
        ),
        trailingIcon = trailingIcon,
        singleLine = true,
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None
    )

    if (errorMsg != "") {
        Text(
            text = errorMsg,
            fontSize = 12.sp,
            color = Red700
        )
    }

}