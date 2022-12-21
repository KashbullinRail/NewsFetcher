package com.example.newsfetcher.feature.detailscreen.di

import com.example.newsfetcher.feature.detailscreen.data.DetailLocalSource
import com.example.newsfetcher.feature.detailscreen.data.DetailRepository
import com.example.newsfetcher.feature.detailscreen.data.model.DetailRepositoryImpl
import com.example.newsfetcher.feature.detailscreen.domain.DetailInteractor
import com.example.newsfetcher.feature.detailscreen.presentation.DetailScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


const val DETAIL_TABLE = "DETAIL_TABLE"

val detailModule = module {

    single {
        DetailLocalSource(detailDao = get())
    }

    single<DetailRepository> {
        DetailRepositoryImpl(detailLocalSource = get())
    }

    single {
        DetailInteractor(detailRepository = get())
    }

    viewModel {
        DetailScreenViewModel(interactor = get(), bookmarksInteractor = get())
    }

}