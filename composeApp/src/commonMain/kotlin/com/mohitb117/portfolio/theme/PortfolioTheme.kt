package com.mohitb117.portfolio.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val AndroidGreen = Color(0xFF3DDC84)
val SyracuseOrange = Color(0xFFFF6B00)
val DoorDashRed = Color(0xFFFF3008)
val AmazonOrange = Color(0xFFFF9900)
val PnnlTeal = Color(0xFF0D9488)

private val DarkPalette = darkColorScheme(
    primary = AndroidGreen,
    onPrimary = Color(0xFF003919),
    primaryContainer = Color(0xFF0A2617),
    onPrimaryContainer = Color(0xFF69F0AE),
    secondary = SyracuseOrange,
    background = Color(0xFF0E1117),
    surface = Color(0xFF161B22),
    surfaceVariant = Color(0xFF21262D),
    onBackground = Color(0xFFF0F6FC),
    onSurface = Color(0xFFF0F6FC),
    onSurfaceVariant = Color(0xFF9AA0A6),
    outline = Color(0xFF30363D)
)

private val LightPalette = lightColorScheme(
    primary = SyracuseOrange,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFF3E6),
    onPrimaryContainer = Color(0xFFCC5500),
    secondary = PnnlTeal,
    background = Color(0xFFF8F4F1),
    surface = Color.White,
    surfaceVariant = Color(0xFFF3EEEB),
    onBackground = Color(0xFF1C1B1A),
    onSurface = Color(0xFF1C1B1A),
    onSurfaceVariant = Color(0xFF52443D),
    outline = Color(0xFFD7C3B8)
)

@Composable
fun PortfolioTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkPalette else LightPalette,
        content = content
    )
}
