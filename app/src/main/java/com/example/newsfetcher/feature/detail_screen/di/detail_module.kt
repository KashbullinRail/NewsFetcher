package com.example.newsfetcher.feature.detail_screen.di

import com.example.newsfetcher.feature.detail_screen.presentation.DetailScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val detailModule = module {

    viewModel {
        DetailScreenViewModel()
    }

}