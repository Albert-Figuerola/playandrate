package com.albanda.playandrate.presentation.screens.welcome.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albanda.playandrate.R
import com.albanda.playandrate.presentation.components.CreateAccountButton
import com.albanda.playandrate.presentation.components.LoginButton
import com.albanda.playandrate.presentation.ui.theme.Inter_Regular
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Medium
import com.albanda.playandrate.presentation.ui.theme.Orbitron_Regular
import com.albanda.playandrate.presentation.ui.theme.PlayAndRateTheme
import com.albanda.playandrate.presentation.ui.theme.Red500

@Composable
fun WelcomeContent(

) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(top = 10.dp)
    ) {
        Image(
            modifier = Modifier
                .height(100.dp)
                .align(Alignment.Start),
            painter = painterResource(id = R.drawable.play_and_rate_logo),
            contentDescription = "Logo"
        )

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f),
                painter = painterResource(id = R.drawable.controller),
                contentDescription = "Controller"
            )

            Spacer(modifier = Modifier.width(20.dp))

            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f),
                painter = painterResource(id = R.drawable.play_and_rate_logo),
                contentDescription = "Vero controller"
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = "Vive tu pasión gaming en compañía de amigos",
                color = Color.Black,
                fontFamily = Orbitron_Medium,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Escribe reseñas sobre juegos y encuentra artículos con opiniones de otros gamers.",
                color = Color.Black,
                fontFamily = Inter_Regular,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(100.dp))

            LoginButton()
            Spacer(modifier = Modifier.height(10.dp))
            CreateAccountButton()
        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewWelcomeContent() {
    WelcomeContent()
}