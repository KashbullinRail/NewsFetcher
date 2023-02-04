package com.example.newsfetcher.feature.weather.di

import com.example.newsfetcher.feature.weather.data.WeatherAPI
import com.example.newsfetcher.feature.weather.data.WeathersRemoteSource
import com.example.newsfetcher.feature.weather.data.WeathersRepository
import com.example.newsfetcher.feature.weather.data.model.WeathersRepositoryImpl
import com.example.newsfetcher.feature.weather.domain.WeatherInteractor
import org.koin.dsl.module


val weatherInfoModule = module {

    single<WeathersRemoteSource> { WeathersRemoteSource(get<WeatherAPI>()) }

    single<WeathersRepository> { WeathersRepositoryImpl(get<WeathersRemoteSource>()) }

    single<WeatherInteractor> { WeatherInteractor(get<WeathersRepository>()) }

//    viewModel { WeatherScreenViewModel(get<WeatherInteractor>()) }

}