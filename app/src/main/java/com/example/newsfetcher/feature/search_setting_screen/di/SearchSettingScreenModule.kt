package com.example.newsfetcher.feature.search_setting_screen.di

import com.example.newsfetcher.feature.search_setting_screen.presentation.SearchSettingScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val searchSettingScreenModule = module {

    viewModel {
        SearchSettingScreenViewModel()
    }

}