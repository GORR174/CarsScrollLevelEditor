package net.catstack.editor.ui.level.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.unit.dp
import net.catstack.editor.Window
import net.catstack.editor.ui.level.LevelViewModel

@Composable
private fun LevelSettingsView(viewModel: LevelViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        Window.window.keyboard.setShortcut(Key.Escape, viewModel::unselectWave)

        LevelName(viewModel, Modifier.align(Alignment.CenterHorizontally))

        WavesList(
            viewModel,
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 16.dp)
        )

        Column(modifier = Modifier.fillMaxWidth().height(60.dp), verticalArrangement = Arrangement.Center) {
            NewWaveButton(viewModel, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
private fun LevelName(viewModel: LevelViewModel, modifier: Modifier = Modifier) {
    val levelName by remember { viewModel.levelName }
    val saved by remember { viewModel.saved }
    val savedText = if (saved) " - saved!" else ""

    Text(
        levelName + savedText,
        modifier = modifier,
        style = MaterialTheme.typography.h6
    )
}

@Composable
private fun WavesList(viewModel: LevelViewModel, modifier: Modifier = Modifier) {
    val levelModel = remember { viewModel.levelModel }.value ?: return

    Text("Waves:")
    Column(modifier = modifier) {
        WavesList(levelModel, viewModel)
    }
}

@Composable
private fun NewWaveButton(viewModel: LevelViewModel, modifier: Modifier = Modifier) {
    Button(
        onClick = viewModel::addWave,
        modifier = modifier
    ) {
        Text("New wave")
    }
}

@Composable
fun LevelSettings(viewModel: LevelViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
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