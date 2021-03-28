package net.catstack.editor.ui.level.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.unit.dp
import net.catstack.editor.Window
import net.catstack.editor.ui.components.Title
import net.catstack.editor.ui.level.LevelViewModel
import net.catstack.editor.ui.level.settings.wave.selection.WaveSelection
import net.catstack.editor.ui.level.settings.wave.settings.WaveSettings

@Composable
private fun LevelSettingsView(viewModel: LevelViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        Window.window.keyboard.setShortcut(Key.Escape, viewModel::unselectWave)

        LevelName(viewModel)

        Row(Modifier.fillMaxSize()) {
            WaveSelection(viewModel)
            if (viewModel.selectedWave.value != null) {
                Divider(Modifier.width(2.dp).fillMaxHeight())
                WaveSettings(viewModel)
            }
        }
    }
}

@Composable
private fun LevelName(viewModel: LevelViewModel) {
    val levelName by remember { viewModel.levelName }
    val saved by remember { viewModel.saved }
    val savedText = if (saved) " - saved!" else ""

    Title(levelName + savedText)
}

@Composable
fun LevelSettings(viewModel: LevelViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        if (viewModel.levelModel.value != null) {
            LevelSettingsView(viewModel)
        } else {
            Box(Modifier.fillMaxSize()) {
                Text("Open level or create new level", modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}