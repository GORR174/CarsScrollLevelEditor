package net.catstack.editor

import androidx.compose.desktop.AppWindow
import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.desktop.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.unit.IntSize
import net.catstack.editor.di.appModules
import net.catstack.editor.themes.DarkTheme
import net.catstack.editor.ui.level.LevelView
import net.catstack.editor.ui.menubar.LevelEditorMenuBar
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        printLogger()
        modules(appModules)

        Window.init()
    }
}

object Window : KoinComponent {

    lateinit var window: AppWindow

    fun init() = Window(
        size = IntSize(900, 720),
        menuBar = LevelEditorMenuBar().getMenuBar()
    ) {
        window = AppWindowAmbient.current!!
        DarkTheme {
            Surface(color = MaterialTheme.colors.background) {
                LevelView(get())
            }
        }
    }
}