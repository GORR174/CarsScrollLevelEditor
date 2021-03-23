package net.catstack.editor.ui.level.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import net.catstack.editor.ui.level.LevelViewModel

@Composable
fun LevelSettings(viewModel: LevelViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Red)
    ) {
        if (viewModel.hasLevel.value) {
            Text(viewModel.text.value)
            Button(onClick = {
                viewModel.text.value = "Hello"
            }) {
                Text("Button")
            }
        }
    }
}