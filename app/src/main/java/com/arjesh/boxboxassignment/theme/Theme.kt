package com.arjesh.boxboxassignment.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.White

private val DarkColorScheme = darkColorScheme(
    primary = Black,
    secondary = Red,
    tertiary = Orange,
    onPrimary = White,
    onSecondary = White,
)

@Composable
fun BoxBoxAssignmentTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}