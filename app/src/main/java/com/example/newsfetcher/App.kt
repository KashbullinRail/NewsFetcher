package com.example.newsfetcher

import android.app.Application
import com.example.newsfetcher.di.databaseModule
import com.example.newsfetcher.di.networkModule
import com.example.newsfetcher.feature.bookmarks_screen.di.bookmarksScreenModule
import com.example.newsfetcher.feature.detail_screen.di.detailScreenModule
import com.example.newsfetcher.feature.main_screen.news.di.mainScreenModule
import com.example.newsfetcher.feature.search_screen.di.searchScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                networkModule,
                mainScreenModule,
                bookmarksScreenModule,
                databaseModule,
                detailScreenModule,
                searchScreenModule
            )
        }

        // Для принудительного использования темной темы приложением
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

}