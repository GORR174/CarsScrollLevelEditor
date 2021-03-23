package net.catstack.editor

import androidx.compose.desktop.Window
import androidx.compose.material.*
import androidx.compose.ui.unit.IntSize
import net.catstack.editor.di.appModule
import net.catstack.editor.ui.level.LevelView
import net.catstack.editor.ui.menubar.LevelEditorMenuBar
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        printLogger()
        modules(appModule)

        Window.init()
    }
}

object Window : KoinComponent {
    fun init() = Window(
        size = IntSize(900, 720),
        menuBar = LevelEditorMenuBar().getMenuBar()
    ) {
        MaterialTheme {
            LevelView(get())
        }
    }
}