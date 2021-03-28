package net.catstack.buildjar

val org.gradle.api.Project.catJar: BuildJarPluginExtension
    get() = this.extensions.getByName("catJar") as BuildJarPluginExtension

fun org.gradle.api.Project.catJar(configure: BuildJarPluginExtension.() -> Unit) {
    this.extensions.configure("catJar", configure)
}