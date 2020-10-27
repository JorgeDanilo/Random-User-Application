package com.example.randomuserapplication.app

import android.app.Application
import com.example.randomuserapplication.app.config.remoteModule
import com.example.randomuserapplication.app.config.repositoryModule
import com.example.randomuserapplication.app.config.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

open class App : Application() {

    private val appModules by lazy {
        listOf(remoteModule, repositoryModule, uiModule)
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(org.koin.core.logger.Level.DEBUG)
            modules(appModules)
        }
    }
}