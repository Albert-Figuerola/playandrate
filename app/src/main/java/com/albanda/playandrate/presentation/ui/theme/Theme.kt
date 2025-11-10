package com.albanda.playandrate.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = DarkBackgroundColor
//    primary = Red500,
//    onPrimary = Color.White,
//    primaryContainer = DarkGray900,
//    secondary = DarkGray700,
//    background = DarkGray900
)

private val LightColorScheme = lightColorScheme(
    background = LightBackgroundColor
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40,
//    onBackground = Color.Red,

)

@Composable
fun PlayAndRateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
//    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val colorScheme = LightColorScheme

    /*val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }*/

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}