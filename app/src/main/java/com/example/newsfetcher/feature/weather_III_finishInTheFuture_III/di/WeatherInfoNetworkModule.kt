package com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.di

import com.example.newsfetcher.feature.main_screen.di.BASE_URL_NEWS_API
import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.WeatherAPI
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val weatherInfoNetworkModule = module{

    single<OkHttpClient> {
        OkHttpClient
            .Builder()
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL_WEATHER)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single<WeatherAPI> {
        get<Retrofit>()
            .create(WeatherAPI::class.java)
    }

}

