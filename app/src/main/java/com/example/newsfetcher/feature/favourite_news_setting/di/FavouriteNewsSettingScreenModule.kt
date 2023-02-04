package com.example.newsfetcher.feature.favourite_news_setting.di

import com.example.newsfetcher.feature.favourite_news_setting.presentation.FavouriteNewsSettingScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favouriteNewsSettingScreenModule = module {

    viewModel {
        FavouriteNewsSettingScreenViewModel(articlesInteractor = get())
    }

}