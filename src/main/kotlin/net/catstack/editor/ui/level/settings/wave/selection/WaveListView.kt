package net.catstack.editor.ui.level.settings.wave.selection

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.unit.dp
import net.catstack.editor.models.LevelModel
import net.catstack.editor.models.WaveModel
import net.catstack.editor.ui.level.LevelViewModel

@Composable
fun WavesList(levelModel: LevelModel, viewModel: LevelViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        levelModel.wavesData.forEachIndexed { index, waveModel ->
            WavesListItem(waveModel, viewModel, index)
        }
    }
}

@Composable
fun WavesListItem(waveModel: WaveModel, viewModel: LevelViewModel, waveIndex: Int) {
    val selectedWave = remember { viewModel.selectedWave }.value

    val selectionColor = MaterialTheme.colors.primary
    val selectionBgColor = Color(0x22FFFFFF)

    val textColor = remember { mutableStateOf(Color.Unspecified) }
    val bgColor = if (waveModel == selectedWave) selectionBgColor else Color.Unspecified

    Column(modifier = Modifier.background(color = bgColor)) {
        Text("Wave ${waveIndex + 1}", modifier = Modifier
            .pointerMoveFilter(onEnter = {
                textColor.value = selectionColor
                return@pointerMoveFilter true
            }, onExit = {
                textColor.value = Color.Unspecified
                return@pointerMoveFilter true
            })
            .fillMaxWidth()
            .clickable { viewModel.selectWave(waveModel) }
            .padding(8.dp),
            color = if (waveModel == selectedWave) selectionColor else textColor.value)

        Divider(modifier = Modifier.fillMaxWidth())
    }
}