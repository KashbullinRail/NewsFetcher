package com.example.newsfetcher

import android.app.Application
import com.example.newsfetcher.di.databaseModule
import com.example.newsfetcher.di.networkModule
import com.example.newsfetcher.di.sourceDatabaseModule
import com.example.newsfetcher.feature.bookmarks_screen.di.bookmarksScreenModule
import com.example.newsfetcher.feature.detail_screen.di.detailScreenModule
import com.example.newsfetcher.feature.favourite_news_setting_screen.di.favouriteNewsSettingScreenModule
import com.example.newsfetcher.feature.main_screen.di.mainScreenModule
import com.example.newsfetcher.feature.news_source_screen.di.sourceScreenModule
import com.example.newsfetcher.feature.search_screen.di.searchScreenModule
import com.example.newsfetcher.feature.search_setting_screen.di.searchSettingScreenModule
import com.example.newsfetcher.feature.source_setting_screen.di.sourceNewsSettingScreenModule
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
                searchScreenModule,
                searchSettingScreenModule,
                favouriteNewsSettingScreenModule,
                sourceScreenModule,
                sourceNewsSettingScreenModule,
                sourceDatabaseModule
//                weatherInfoModule,
//                weatherInfoNetworkModule
            )
        }
    }

}