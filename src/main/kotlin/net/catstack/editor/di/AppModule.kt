package net.catstack.editor.di

import com.google.gson.GsonBuilder
import net.catstack.editor.domain.LevelRepository
import net.catstack.editor.ui.level.LevelViewModel
import org.koin.dsl.module

val appModule = module {
    single { LevelViewModel() }

    single { LevelRepository(get()) }

    single {
        GsonBuilder()
            .setPrettyPrinting()
            .create()
    }
}

val appModules = listOf(appModule)