package net.catstack.editor.ui.level.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GamePreview() {
    Column(
        modifier = Modifier
            .preferredWidth(405.dp)
            .fillMaxHeight()
            .background(Color.Cyan)
    ) {

    }
}