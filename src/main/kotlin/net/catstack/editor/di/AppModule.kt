package net.catstack.editor.di

import net.catstack.editor.ui.level.LevelViewModel
import org.koin.dsl.module

val appModule = module {
    single { LevelViewModel() }
}