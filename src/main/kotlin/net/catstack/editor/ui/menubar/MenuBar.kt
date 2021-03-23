package net.catstack.editor.ui.menubar

import androidx.compose.ui.window.Menu
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.MenuItem
import net.catstack.editor.domain.LevelRepository
import net.catstack.editor.ui.level.LevelViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.File
import javax.swing.JFileChooser
import javax.swing.KeyStroke
import javax.swing.filechooser.FileNameExtensionFilter

class LevelEditorMenuBar : KoinComponent {
    private val levelViewModel by inject<LevelViewModel>()
    private val levelRepository by inject<LevelRepository>()

    private val menu = Menu(
        "File",
        MenuItem(
            "New", onClick = {
                val fileChooser = JFileChooser(".")
                fileChooser.dialogType = JFileChooser.SAVE_DIALOG
                fileChooser.removeChoosableFileFilter(fileChooser.fileFilter)
                fileChooser.fileFilter = FileNameExtensionFilter("json", "json")
                val result = fileChooser.showSaveDialog(null)

                if (result == JFileChooser.APPROVE_OPTION) {
                    var selectedPath = fileChooser.selectedFile.path
                    if (!selectedPath.endsWith(".json"))
                        selectedPath += ".json"
                    val levelModel = levelRepository.createNewLevel(File(selectedPath))
                    levelViewModel.levelModel.value = levelModel
                    println("New file created!")
                }
            }, shortcut = KeyStroke.getKeyStroke("control N")
        ),
        MenuItem(
            "Open", onClick = {
                println("Opened!")
            }, shortcut = KeyStroke.getKeyStroke("control O")
        ),
        MenuItem(
            "Close", onClick = {
                levelViewModel.levelModel.value = null
                println("Closed!")
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
