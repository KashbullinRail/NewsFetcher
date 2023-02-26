package com.example.newsfetcher.feature.source_bookmarks_screen.di

import com.example.newsfetcher.feature.source_bookmarks_screen.data.SourceBookmarksLocalSource
import com.example.newsfetcher.feature.source_bookmarks_screen.data.model.SourceBookmarksRepositoryImpl
import com.example.newsfetcher.feature.source_bookmarks_screen.domain.SourceBookmarksInteractor
import com.example.newsfetcher.feature.source_bookmarks_screen.domain.SourceBookmarksRepository
import com.example.newsfetcher.feature.source_bookmarks_screen.presentation.SourceBookmarksScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val sourceBookmarksScreenModule = module {

    single {
        SourceBookmarksLocalSource(sourceBookmarksDao = get())
    }

    single<SourceBookmarksRepository> {
        SourceBookmarksRepositoryImpl(sourceBookmarksLocalSource = get())
    }

    single {
        SourceBookmarksInteractor(sourceBookmarksRepository = get())
    }

    viewModel {
        SourceBookmarksScreenViewModel(sourceBookmarksInteractor = get())
    }

}