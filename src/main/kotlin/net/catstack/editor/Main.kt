package net.catstack.editor

import androidx.compose.desktop.AppWindow
import androidx.compose.desktop.LocalAppWindow
import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import net.catstack.editor.di.appModules
import net.catstack.editor.themes.DarkTheme
import net.catstack.editor.ui.level.LevelView
import net.catstack.editor.ui.menubar.LevelEditorMenuBar
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import java.awt.Dimension
import javax.swing.UIManager

fun main() {
    startKoin {
        printLogger()
        modules(appModules)

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        Window.init()
    }
}

object Window : KoinComponent {

    lateinit var window: AppWindow
    lateinit var sizeState: MutableState<IntSize>

    fun init() = Window(
        size = IntSize(900, 720),
        menuBar = LevelEditorMenuBar().getMenuBar()
    ) {
        window = LocalAppWindow.current
        sizeState = mutableStateOf(IntSize(window.width, window.height))
        window.events.onResize = {
            sizeState.value = IntSize(it.width, it.height)
            window.window.minimumSize = Dimension((it.height / 18 * 9) + 600, 480)
        }
        DarkTheme {
            Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
                LevelView(get())
            }
        }
    }
}