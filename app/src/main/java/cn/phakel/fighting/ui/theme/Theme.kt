package cn.phakel.fighting.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
        primary = Red165,
        primaryVariant = Black33,
        secondary = Gray117,
        secondaryVariant = Gray189,
        error = Red244
)

private val LightColorPalette = lightColors(
        primary = Red165,
        primaryVariant = Black33,
        secondary = Gray117,
        secondaryVariant = Gray189,
        error = Red244
)

@Composable
fun FightingTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
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