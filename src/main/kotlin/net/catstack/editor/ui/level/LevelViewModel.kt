package net.catstack.editor.ui.level

import androidx.compose.runtime.mutableStateOf
import net.catstack.editor.common.ViewModel
import net.catstack.editor.domain.LevelRepository
import net.catstack.editor.models.LevelModel
import net.catstack.editor.models.WaveModel
import java.io.File

class LevelViewModel(private val levelRepository: LevelRepository) : ViewModel() {
    val levelModel = mutableStateOf<LevelModel?>(null)
    val levelName = mutableStateOf("")
    private var levelFile: File? = null

    fun addWave(repeats: Int = 1) {
        if (levelModel.value != null) {
            val newWaveModel = WaveModel(1, listOf())
            val newWavesData = ArrayList(levelModel.value?.wavesData) + newWaveModel

            levelModel.value = LevelModel(newWavesData)
        }
    }

    fun createNewLevel(levelFile: File) {
        val levelModel = levelRepository.createNewLevel(levelFile)
        this.levelModel.value = levelModel
        this.levelName.value = levelFile.name
        this.levelFile = levelFile
    }

    fun closeLevel() {
        levelFile = null
        levelModel.value = null
    }

    fun loadLevel(levelFile: File) {
        val levelModel = levelRepository.loadLevelFromFile(levelFile)
        this.levelModel.value = levelModel
        this.levelName.value = levelFile.name
        this.levelFile = levelFile
    }

    fun saveLevel(): Boolean {
        saveLevelAs(levelFile ?: return false)
        return true
    }

    fun saveLevelAs(levelFile: File): Boolean {
        levelRepository.saveLevel(levelFile, levelModel.value ?: return false)
        this.levelName.value = levelFile.name
        this.levelFile = levelFile
        return true
    }
}