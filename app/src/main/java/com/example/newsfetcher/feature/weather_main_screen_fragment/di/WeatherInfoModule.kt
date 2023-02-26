package com.example.newsfetcher.feature.weather_main_screen_fragment.di

import com.example.newsfetcher.feature.weather_main_screen_fragment.data.WeatherAPI
import com.example.newsfetcher.feature.weather_main_screen_fragment.data.WeathersRemoteSource
import com.example.newsfetcher.feature.weather_main_screen_fragment.data.WeathersRepository
import com.example.newsfetcher.feature.weather_main_screen_fragment.data.model.WeathersRepositoryImpl
import com.example.newsfetcher.feature.weather_main_screen_fragment.domain.WeatherInteractor
import org.koin.dsl.module


val weatherInfoModule = module {

    single<WeathersRemoteSource> { WeathersRemoteSource(get<WeatherAPI>()) }

    single<WeathersRepository> { WeathersRepositoryImpl(get<WeathersRemoteSource>()) }

    single<WeatherInteractor> { WeatherInteractor(get<WeathersRepository>()) }

//    viewModel { WeatherScreenViewModel(get<WeatherInteractor>()) }

}