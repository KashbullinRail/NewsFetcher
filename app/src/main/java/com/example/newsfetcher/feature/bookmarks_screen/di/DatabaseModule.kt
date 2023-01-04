package com.example.newsfetcher.di

import androidx.room.Room
import com.example.newsfetcher.AppDataBase
import com.example.newsfetcher.feature.bookmarks_screen.di.APP_DATABASE
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {

    single {
        Room
            .databaseBuilder(androidContext(), AppDataBase::class.java, APP_DATABASE)
            .fallbackToDestructiveMigration()
            .build()
    }
    single {
        get<AppDataBase>().bookmarksDao()
    }

}
