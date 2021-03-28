package net.catstack.editor.ui.level.preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import net.catstack.editor.Window

@Composable
fun GamePreview() {
    val windowSize = remember { Window.sizeState }.value
    val height = windowSize.height
    Column(
        modifier = Modifier
            .requiredWidth((height / 18 * 9).dp)
            .fillMaxHeight()
            .background(Color.Cyan)
    ) {
        Image(imageResource("road.png"), "", contentScale = ContentScale.FillHeight)
    }
}