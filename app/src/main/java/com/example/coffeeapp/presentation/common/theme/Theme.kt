package com.example.coffeeapp.presentation.common.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Brown40,
    onPrimary = Color.White,
    secondary = Ivory,
    tertiary = Color.Black,
    surface = Color.White,
    onSurface = Grey80,
    onSurfaceVariant = Color.Gray,
    outline = LightGrey,
    background = Color(0xFFFDFDFD)
)

private val DarkColorScheme = darkColorScheme(
    primary = Brown80,
    onPrimary = Color.White,
    secondary = Color.DarkGray,
    tertiary = Color.LightGray,
    surface = Grey80,
    onSurface = Color.White,
    onSurfaceVariant = Color.LightGray,
    background = Color(0xFF121212)
)

@Composable
fun CoffeeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}