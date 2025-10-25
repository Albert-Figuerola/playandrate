package com.albanda.playandrate.presentation.screens.profile_update.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.albanda.playandrate.presentation.components.DefaultButton
import com.albanda.playandrate.presentation.components.DefaultTextFiled
import com.albanda.playandrate.presentation.screens.profile_update.ProfileUpdateViewModel
import com.albanda.playandrate.presentation.ui.theme.DarkGray500

@Composable
fun CardForm(
    profileUpdateViewModel: ProfileUpdateViewModel = hiltViewModel()
) {

    val state = profileUpdateViewModel.state

    Card(
        modifier = Modifier
            .padding(start = 40.dp, end = 40.dp, top = 200.dp),
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
                text = "EDITAR",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Introduce el nuevo nombre de usuario.",
                fontSize = 12.sp,
                color = Color.Gray
            )

            DefaultTextFiled(
                modifier = Modifier.padding(top = 16.dp),
                value = state.username,
                onValueChange = { profileUpdateViewModel.onUsernameInput(it) },
                label = "Nombre de usuario",
                leadingIcon = Icons.Default.Person,
                errorMsg = profileUpdateViewModel.usernameErrMsg,
                validateField = { profileUpdateViewModel.validateUsername() }
            )

            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                onClick = { profileUpdateViewModel.saveImage() },
                text = "ACTUALIZAR DATOS"
            )
        }
    }

}