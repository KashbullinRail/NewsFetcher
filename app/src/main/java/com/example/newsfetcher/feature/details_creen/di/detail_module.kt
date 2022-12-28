package com.example.newsfetcher.feature.details_creen.di

import com.example.newsfetcher.feature.details_creen.data.DetailLocalSource
import com.example.newsfetcher.feature.details_creen.data.DetailRepository
import com.example.newsfetcher.feature.details_creen.data.model.DetailRepositoryImpl
import com.example.newsfetcher.feature.details_creen.domain.DetailInteractor
import com.example.newsfetcher.feature.details_creen.presentation.DetailScreenViewModel
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
        DetailScreenViewModel(detailInteractor = get(), bookmarksInteractor = get())
    }

}