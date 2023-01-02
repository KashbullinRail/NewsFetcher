package com.example.newsfetcher.di

import androidx.room.Room
import com.example.newsfetcher.AppDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


const val APP_DATABASE = "APP_DATABASE"


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
