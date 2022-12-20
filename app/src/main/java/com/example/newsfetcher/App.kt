package com.example.newsfetcher

import android.app.Application
import com.example.newsfetcher.di.databaseModule
import com.example.newsfetcher.di.networkModule
import com.example.newsfetcher.feature.bookmarks.di.bookmarksModule
import com.example.newsfetcher.feature.detailscreen.di.detailModule
import com.example.newsfetcher.feature.main_screen.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(networkModule, mainScreenModule, bookmarksModule, databaseModule, detailModule)
        }

        // Для использования темной темы приложением
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

}