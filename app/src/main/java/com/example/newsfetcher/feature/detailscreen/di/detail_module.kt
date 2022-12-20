package com.example.newsfetcher.feature.detailscreen.di

import com.example.newsfetcher.feature.detailscreen.data.DetailLocalSource
import com.example.newsfetcher.feature.detailscreen.data.DetailRepository
import com.example.newsfetcher.feature.detailscreen.data.model.DetailRepositoryImpl
import com.example.newsfetcher.feature.detailscreen.domain.DetailInteractor
import com.example.newsfetcher.feature.detailscreen.presentation.DetailScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


const val BOOKMARKS_TABLE = "BOOKMARKS_TABLE"

val detailModule = module {

    single {
        DetailLocalSource(bookmarksDao = get())
    }

    single<DetailRepository> {
        DetailRepositoryImpl(bookmarksLocalSource = get())
    }

    single {
        DetailInteractor(bookmarksRepository = get())
    }

    viewModel {
        DetailScreenViewModel(interactor = get())
    }

}