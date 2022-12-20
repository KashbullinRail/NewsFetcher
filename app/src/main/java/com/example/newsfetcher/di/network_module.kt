package com.example.newsfetcher.di


import android.util.Log
import androidx.room.Room
import com.example.newsfetcher.AppDataBase
import com.example.newsfetcher.base.HeaderIntercepter
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://newsapi.org/"
const val API_KEY: String = "8d8a631cc60f433ab84de75d98294065"
const val APP_DATABASE = "APP_DATABASE"

val networkModule = module {

    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor { message ->
            Log.d("OkHttp", message)
        }.apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    single<OkHttpClient> {
        OkHttpClient
            .Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addNetworkInterceptor(HeaderIntercepter())
            .callTimeout(20000L, TimeUnit.MILLISECONDS)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }
}

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
