package net.catstack.editor.ui.menubar

import androidx.compose.ui.window.Menu
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.MenuItem
import net.catstack.editor.ui.level.LevelViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import javax.swing.KeyStroke

class LevelEditorMenuBar : KoinComponent {
    private val levelViewModel by inject<LevelViewModel>()

    private val menu = Menu(
        "File",
        MenuItem(
            "New", onClick = {
                println("New file created!")
                levelViewModel.hasLevel.value = true
            }, shortcut = KeyStroke.getKeyStroke("control N")
        ),
        MenuItem(
            "Open", onClick = {
                println("Opened!")
                levelViewModel.hasLevel.value = true
            }, shortcut = KeyStroke.getKeyStroke("control O")
        ),
        MenuItem(
            "Close", onClick = {
                println("Closed!")
                levelViewModel.hasLevel.value = false
            }
        ),
        MenuItem(
            "Save as", onClick = {
                println("Saved!")
            }, shortcut = KeyStroke.getKeyStroke("control C")
        ),
    )

    fun getMenuBar() = MenuBar(menu)
}
