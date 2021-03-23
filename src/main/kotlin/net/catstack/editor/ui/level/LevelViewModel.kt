package net.catstack.editor.ui.level

import androidx.compose.runtime.mutableStateOf
import net.catstack.editor.common.ViewModel

class LevelViewModel : ViewModel() {
    var text = mutableStateOf("Test")
    var hasLevel = mutableStateOf(false)
}