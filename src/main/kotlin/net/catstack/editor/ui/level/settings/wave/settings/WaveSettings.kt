package net.catstack.editor.ui.level.settings.wave.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.catstack.editor.ui.components.Title
import net.catstack.editor.ui.level.LevelViewModel

@Composable
fun WaveSettings(viewModel: LevelViewModel) {
    Column(Modifier.fillMaxSize()) {
        Title("Edit wave")
    }
}