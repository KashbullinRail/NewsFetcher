package com.example.newsfetcher.feature.source_setting_screen.di

import com.example.newsfetcher.feature.source_setting_screen.presentation.SourceNewsSettingScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val favouriteNewsSettingScreenModule = module {

    viewModel {
        SourceNewsSettingScreenViewModel(sourcesInteractor = get())
    }

}