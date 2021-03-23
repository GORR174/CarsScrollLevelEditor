package net.catstack.editor.ui.level

import androidx.compose.runtime.mutableStateOf
import net.catstack.editor.common.ViewModel
import net.catstack.editor.models.LevelModel

class LevelViewModel : ViewModel() {
    val text = mutableStateOf("Test")
    val levelModel = mutableStateOf<LevelModel?>(null)
}