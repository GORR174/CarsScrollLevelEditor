package net.catstack.editor.domain

import com.google.gson.Gson
import net.catstack.editor.models.LevelModel
import java.io.File

class LevelRepository(private val gson: Gson) {
    fun createNewLevel(levelFile: File): LevelModel {
        println(levelFile.absolutePath)
        levelFile.createNewFile()
        val levelModel = LevelModel(listOf())
        levelFile.writeText(gson.toJson(levelModel))
        return levelModel
    }
}