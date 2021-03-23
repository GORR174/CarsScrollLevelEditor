package net.catstack.editor.themes

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun DarkTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = darkColors(
            background = Color(0xFF393939),
        ),
        content = content,
    )
}