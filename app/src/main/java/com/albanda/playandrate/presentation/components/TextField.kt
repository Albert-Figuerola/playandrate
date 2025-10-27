package com.albanda.playandrate.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albanda.playandrate.presentation.ui.theme.Inter_Regular
import com.albanda.playandrate.presentation.ui.theme.Red700

@Composable
fun TextFiled(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    validateField: () -> Unit = {},
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    errorMsg: String = ""
) {

    Column() {
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
//                    color = Color.White,
                    fontFamily = Inter_Regular,
                    fontSize = 14.sp
                )
            },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = Color(0xFFD8D9DD),
                unfocusedContainerColor = Color(0xFFD8D9DD),
//                focusedTextColor = Color.Black,
//                unfocusedTextColor = Color.DarkGray,
//                focusedLabelColor = Color(0xFF00796B),
//                unfocusedLabelColor = Color.Gray,
//                focusedBorderColor = Color(0xFF00796B),
//                unfocusedBorderColor = Color.Gray,
//                cursorColor = Color(0xFF00796B)
            )
        )

        if (errorMsg != "") {
            Text(
                text = errorMsg,
                fontSize = 12.sp,
                color = Red700
            )
        }

    }

//    Column() {
//        OutlinedTextField(
//            modifier = modifier,
//            value = value,
//            onValueChange = {
//                onValueChange(it)
//                validateField()
//            },
//            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
//            label = { Text(label) },
//            leadingIcon = {
//                Icon(
//                    imageVector = leadingIcon,
//                    contentDescription = "",
//                    tint = Color.White
//                )
//            },
//            trailingIcon = trailingIcon,
//            singleLine = true,
//            visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None
//        )
//        if (errorMsg != "") {
//            Text(
//                text = errorMsg,
//                fontSize = 12.sp,
//                color = Red700
//            )
//        }
//
//    }
}