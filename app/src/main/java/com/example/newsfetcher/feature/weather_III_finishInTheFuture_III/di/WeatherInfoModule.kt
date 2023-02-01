package com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.di

import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.WeatherAPI
import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.WeathersRemoteSource
import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.WeathersRepository
import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.data.model.WeathersRepositoryImpl
import com.example.newsfetcher.feature.weather_III_finishInTheFuture_III.domain.WeatherInteractor
import org.koin.dsl.module


val weatherInfoModule = module {

    single<WeathersRemoteSource> { WeathersRemoteSource(get<WeatherAPI>()) }

    single<WeathersRepository> { WeathersRepositoryImpl(get<WeathersRemoteSource>()) }

    single<WeatherInteractor> { WeatherInteractor(get<WeathersRepository>()) }

//    viewModel { WeatherScreenViewModel(get<WeatherInteractor>()) }

}