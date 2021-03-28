import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import net.catstack.buildjar.BuildJarPlugin
import net.catstack.buildjar.catJar

plugins {
    kotlin("jvm") version "1.4.31"
    id("org.jetbrains.compose") version "0.4.0-build177"
}

apply<BuildJarPlugin>()

val thisProjectVersion = "1.0.0"

group = "net.catstack"
version = thisProjectVersion

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

dependencies {
    // Koin
    implementation("io.insert-koin:koin-core-ext:3.0.1-beta-2")

    // Gson
    implementation("com.google.code.gson:gson:2.8.6")

    implementation(compose.desktop.currentOs)

    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "14"
}

compose.desktop {
    application {
        mainClass = "net.catstack.editor.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Msi, TargetFormat.Exe)
            packageName = "ScrollLevelEditor"
            packageVersion = thisProjectVersion
        }
    }
}

catJar {
    projectName = rootProject.name
    projectVersion = thisProjectVersion
}