package net.catstack.editor.ui.level

import androidx.compose.runtime.mutableStateOf
import net.catstack.editor.common.ViewModel
import net.catstack.editor.models.LevelModel
import net.catstack.editor.models.WaveModel

class LevelViewModel : ViewModel() {
    val levelModel = mutableStateOf<LevelModel?>(null)
    val levelName = mutableStateOf("")

    fun addWave(repeats: Int = 1) {
        if (levelModel.value != null) {
            val newWaveModel = WaveModel(1, listOf())
            val newWavesData = ArrayList(levelModel.value?.wavesData) + newWaveModel

            levelModel.value = LevelModel(newWavesData)
        }
    }
}