package net.catstack.editor.ui.level.settings.wave.selection

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.catstack.editor.ui.components.TitleBox
import net.catstack.editor.ui.level.LevelViewModel

@Composable
fun WaveSelection(viewModel: LevelViewModel) {
    val wavesModifier = if (viewModel.selectedWave.value == null) Modifier.fillMaxWidth() else Modifier.width(200.dp)
    Column(modifier = wavesModifier.fillMaxHeight()) {
        WavesListContainer(
            viewModel,
            Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        Column(modifier = Modifier.fillMaxWidth().height(60.dp), verticalArrangement = Arrangement.Center) {
            NewWaveButton(viewModel, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
private fun WavesListContainer(viewModel: LevelViewModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        val levelModel = remember { viewModel.levelModel }.value ?: return

        TitleBox {
            Text("Waves:", modifier = Modifier.padding(start = 8.dp))
        }
        Column(modifier = Modifier.fillMaxSize()) {
            WavesList(levelModel, viewModel)
        }
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