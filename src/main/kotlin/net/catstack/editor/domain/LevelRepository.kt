package net.catstack.editor.domain

import com.google.gson.Gson
import net.catstack.editor.models.LevelModel
import java.io.File

class LevelRepository(private val gson: Gson) {
    fun createNewLevel(levelFile: File): LevelModel {
        levelFile.createNewFile()
        val levelModel = LevelModel(listOf())
        levelFile.writeText(gson.toJson(levelModel))
        return levelModel
    }

    fun saveLevel(levelFile: File, levelModel: LevelModel) {
        levelFile.createNewFile()
        levelFile.writeText(gson.toJson(levelModel))
    }

    fun loadLevelFromFile(levelFile: File): LevelModel {
        return gson.fromJson(levelFile.readText(), LevelModel::class.java)
    }
}