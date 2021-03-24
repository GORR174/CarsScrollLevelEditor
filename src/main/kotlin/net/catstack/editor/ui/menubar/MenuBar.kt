package net.catstack.editor.ui.menubar

import androidx.compose.ui.window.Menu
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.MenuItem
import net.catstack.editor.Window
import net.catstack.editor.ui.level.LevelViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.File
import javax.swing.JFileChooser
import javax.swing.JOptionPane
import javax.swing.KeyStroke
import javax.swing.filechooser.FileNameExtensionFilter

class LevelEditorMenuBar : KoinComponent {
    private val levelViewModel by inject<LevelViewModel>()

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
                    val levelFile = File(selectedPath)
                    levelViewModel.createNewLevel(levelFile)
                    println("New file created!")
                }
            }, shortcut = KeyStroke.getKeyStroke("control N")
        ),
        MenuItem(
            "Open", onClick = {
                val fileChooser = JFileChooser(".")
                fileChooser.dialogType = JFileChooser.OPEN_DIALOG
                fileChooser.removeChoosableFileFilter(fileChooser.fileFilter)
                fileChooser.fileFilter = FileNameExtensionFilter("json", "json")
                val result = fileChooser.showOpenDialog(null)

                if (result == JFileChooser.APPROVE_OPTION) {
                    var selectedPath = fileChooser.selectedFile.path
                    if (!selectedPath.endsWith(".json"))
                        selectedPath += ".json"
                    val levelFile = File(selectedPath)
                    if (!levelFile.exists()) {
                        JOptionPane.showMessageDialog(
                            Window.window.window,
                            "Указанного файла не существует или он имеет неверный формат",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                        )
                        return@MenuItem
                    }
                    levelViewModel.loadLevel(levelFile)
                    println("Opened!")
                }
            }, shortcut = KeyStroke.getKeyStroke("control O")
        ),
        MenuItem(
            "Close", onClick = {
                levelViewModel.closeLevel()
                println("Closed!")
            }
        ),
        MenuItem(
            "Save as", onClick = {
                if (levelViewModel.levelModel.value == null) {
                    JOptionPane.showMessageDialog(
                        Window.window.window,
                        "Ошибка при сохранении файла",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    )
                    return@MenuItem
                }
                val fileChooser = JFileChooser(".")
                fileChooser.dialogType = JFileChooser.SAVE_DIALOG
                fileChooser.removeChoosableFileFilter(fileChooser.fileFilter)
                fileChooser.fileFilter = FileNameExtensionFilter("json", "json")
                val result = fileChooser.showSaveDialog(null)

                if (result == JFileChooser.APPROVE_OPTION) {
                    var selectedPath = fileChooser.selectedFile.path
                    if (!selectedPath.endsWith(".json"))
                        selectedPath += ".json"
                    val levelFile = File(selectedPath)
                    if (levelViewModel.saveLevelAs(levelFile)) {
                        println("Saved as!")
                    } else {
                        JOptionPane.showMessageDialog(
                            Window.window.window,
                            "Ошибка при сохранении файла",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                        )
                    }
                }
            }, shortcut = KeyStroke.getKeyStroke("control S")
        ),
        MenuItem(
            "Save", onClick = {
                if (levelViewModel.saveLevel()) {
                    println("Saved!")
                } else {
                    JOptionPane.showMessageDialog(
                        Window.window.window,
                        "Ошибка при сохранении файла",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    )
                }
            }, shortcut = KeyStroke.getKeyStroke("control shift S")
        ),
    )

    fun getMenuBar() = MenuBar(menu)
}
