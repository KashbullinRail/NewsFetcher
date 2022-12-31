package com.example.newsfetcher.feature.details_creen.di

import com.example.newsfetcher.feature.details_creen.presentation.DetailScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val detailModule = module {

    viewModel {
        DetailScreenViewModel()
    }

}