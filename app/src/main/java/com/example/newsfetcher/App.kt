package com.example.newsfetcher

import android.app.Application
import com.example.newsfetcher.di.databaseModule
import com.example.newsfetcher.di.networkModule
import com.example.newsfetcher.feature.bookmarks_screen.di.bookmarksModule
import com.example.newsfetcher.feature.details_creen.di.detailModule
import com.example.newsfetcher.feature.main_screen.di.mainScreenModule
import com.example.newsfetcher.feature.main_screen.presentation.UsersService
import com.example.newsfetcher.feature.search_screen.di.searchScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {

    val usersService = UsersService()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                networkModule,
                mainScreenModule,
                bookmarksModule,
                databaseModule,
                detailModule,
                searchScreenModule
            )
        }

        // Для принудительного использования темной темы приложением
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

}