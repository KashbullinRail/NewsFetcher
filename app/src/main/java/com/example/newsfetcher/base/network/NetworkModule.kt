package com.example.newsfetcher.di

import android.util.Log
import com.example.newsfetcher.base.network.HeaderIntercepter
import com.example.newsfetcher.feature.main_screen.di.BASE_URL_NEWS_API
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


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
            .baseUrl(BASE_URL_NEWS_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

}

