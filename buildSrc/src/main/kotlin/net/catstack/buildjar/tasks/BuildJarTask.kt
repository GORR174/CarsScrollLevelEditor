package net.catstack.buildjar.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import java.io.File

open class BuildJarTask : DefaultTask() {
    @Input
    var projectName: String = ""
    @Input
    var projectVersion: String = ""
    @Input
    var projectFolder: String = ""

    @org.gradle.api.tasks.TaskAction
    fun test() {
        val folder = File(projectFolder)
        val inputFile = File("build/compose/jars/$projectName-windows-x64-$projectVersion.jar")
        println(projectName)
        folder.mkdirs()
        inputFile.copyTo(File("$projectFolder/$projectName.jar"), true)
        val batFile = File("$projectFolder/start.bat")
        batFile.createNewFile()
        batFile.writeText("\"runtime\\bin\\java.exe\" -jar ScrollLevelEditor.jar")
    }
}