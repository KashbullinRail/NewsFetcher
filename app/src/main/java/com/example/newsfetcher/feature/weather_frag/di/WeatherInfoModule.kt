package com.example.newsfetcher.feature.weather_frag.di

import com.example.newsfetcher.feature.weather_frag.data.WeatherAPI
import com.example.newsfetcher.feature.weather_frag.data.WeathersRemoteSource
import com.example.newsfetcher.feature.weather_frag.data.WeathersRepository
import com.example.newsfetcher.feature.weather_frag.data.model.WeathersRepositoryImpl
import com.example.newsfetcher.feature.weather_frag.domain.WeatherInteractor
import org.koin.dsl.module


val weatherInfoModule = module {

    single<WeathersRemoteSource> { WeathersRemoteSource(get<WeatherAPI>()) }

    single<WeathersRepository> { WeathersRepositoryImpl(get<WeathersRemoteSource>()) }

    single<WeatherInteractor> { WeatherInteractor(get<WeathersRepository>()) }

//    viewModel { WeatherScreenViewModel(get<WeatherInteractor>()) }

}