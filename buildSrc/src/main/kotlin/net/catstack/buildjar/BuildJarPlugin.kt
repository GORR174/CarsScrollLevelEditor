package net.catstack.buildjar

import org.gradle.api.Plugin
import org.gradle.api.Project
import net.catstack.buildjar.tasks.BuildJarTask

class BuildJarPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create("catJar", BuildJarPluginExtension::class.java)
        target.tasks.register("buildCatJar", BuildJarTask::class.java) {
            it.dependsOn("packageUberJarForCurrentOS")
            it.group = "build"
            it.projectName = extension.projectName
            it.projectVersion = extension.projectVersion
            it.projectFolder = extension.projectFolder
        }
    }
}