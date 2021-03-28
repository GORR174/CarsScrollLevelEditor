package net.catstack.editor.ui.level.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.unit.dp
import net.catstack.editor.Window
import net.catstack.editor.ui.level.LevelViewModel

@Composable
private fun LevelSettingsView(viewModel: LevelViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        val levelModel = remember { viewModel.levelModel }.value ?: return
        val levelName by remember { viewModel.levelName }
        val selectedWave by remember { viewModel.selectedWave }
        val saved by remember { viewModel.saved }
        val savedText = if (saved) " - saved!" else ""

        Window.window.keyboard.setShortcut(Key.Escape, viewModel::unselectWave)

        Text(
            levelName + savedText,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.h6
        )
        Text("Waves:")

        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(top = 16.dp)
        ) {
            val selectionColor = MaterialTheme.colors.primary
            val selectionBgColor = Color(0x22FFFFFF)
            levelModel.wavesData.forEachIndexed { index, waveModel ->
                val color = remember { mutableStateOf(Color.Unspecified) }
                val bgColor = remember { mutableStateOf(Color.Unspecified) }
                Column(modifier = Modifier
                    .background(color = if (waveModel == selectedWave) selectionBgColor else Color.Unspecified)
                ) {
                    Divider(modifier = Modifier.fillMaxWidth())

                    Text("Wave ${index + 1}", modifier = Modifier
                        .pointerMoveFilter(onEnter = {
                            color.value = selectionColor
                            return@pointerMoveFilter true
                        }, onExit = {
                            color.value = Color.Unspecified
                            return@pointerMoveFilter true
                        })
                        .fillMaxWidth()
                        .clickable {
                            bgColor.value = selectionBgColor
                            viewModel.selectWave(waveModel)
                        }
                        .padding(8.dp),
                        color = if (waveModel == selectedWave) selectionColor else color.value)
                }
            }
            if (levelModel.wavesData.isNotEmpty())
                Divider(modifier = Modifier.fillMaxWidth())
        }

        Column(modifier = Modifier.fillMaxWidth().height(60.dp), verticalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    viewModel.addWave()
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("New wave")
            }
        }
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