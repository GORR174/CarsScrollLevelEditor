package net.catstack.editor.ui.level

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import net.catstack.editor.ui.level.preview.GamePreview
import net.catstack.editor.ui.level.settings.LevelSettings

@Composable
fun LevelView(viewModel: LevelViewModel) {
    Row {
        GamePreview()
        LevelSettings(viewModel)
    }
}
