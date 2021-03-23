package net.catstack.editor.ui.level.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.catstack.editor.ui.level.LevelViewModel

@Composable
private fun LevelSettingsView(viewModel: LevelViewModel, columnScope: ColumnScope) = columnScope.apply {
    Text(viewModel.levelName.value, modifier = Modifier.align(Alignment.CenterHorizontally), style = MaterialTheme.typography.h6)
    Text(viewModel.text.value)

    Column(modifier = Modifier.fillMaxWidth().weight(1f)) {

    }

    Column(modifier = Modifier.fillMaxWidth().height(60.dp), verticalArrangement = Arrangement.Center) {
        Button(onClick = {
            viewModel.text.value = "Hello"
        },
        modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Button")
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
            LevelSettingsView(viewModel, this)
        } else {
            Box(Modifier.fillMaxSize()) {
                Text("Open level or create new level", modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}