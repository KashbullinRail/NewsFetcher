package com.example.newsfetcher.di

import androidx.room.Room
import com.example.newsfetcher.AppDataBase
import com.example.newsfetcher.AppSourceDataBase
import com.example.newsfetcher.feature.source_bookmarks_screen.di.APP_SOURCE_DATABASE
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val sourceDatabaseModule = module {

    single {
        Room
            .databaseBuilder(androidContext(), AppSourceDataBase::class.java, APP_SOURCE_DATABASE)
            .fallbackToDestructiveMigration()
            .build()
    }
    single {
        get<AppSourceDataBase>().sourceBookmarksDao()
    }

}
