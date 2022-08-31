package com.the1stenhancer.capp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = myPrimaryDark,
    primaryVariant = myPrimaryVariant,
    secondary = myPrimaryContainer,
    secondaryVariant = myPrimaryContainer,
    onPrimary = Color.White,
)

private val LightColorPalette = lightColors(
    primary = myPrimaryLight,
    primaryVariant = myPrimaryVariant,
    secondary = myPrimaryContainer,
    secondaryVariant = myPrimaryContainer

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CappTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}