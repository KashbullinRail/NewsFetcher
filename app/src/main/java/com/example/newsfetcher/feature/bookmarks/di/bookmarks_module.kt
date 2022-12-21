package com.example.newsfetcher.feature.bookmarks.di

import com.example.newsfetcher.feature.bookmarks.data.BookmarksLocalSource
import com.example.newsfetcher.feature.bookmarks.data.BookmarksRepository
import com.example.newsfetcher.feature.bookmarks.data.model.BookmarksRepositoryImpl
import com.example.newsfetcher.feature.bookmarks.domian.BookmarksInteractor
import com.example.newsfetcher.feature.bookmarks.presentation.BookmarksScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


const val BOOKMARKS_TABLE = "BOOKMARKS_TABLE"

val bookmarksModule = module {

    single {
        BookmarksLocalSource(bookmarksDao = get())
    }

    single<BookmarksRepository> {
        BookmarksRepositoryImpl(bookmarksLocalSource = get())
    }

    single {
        BookmarksInteractor(bookmarksRepository = get())
    }

    viewModel {
        BookmarksScreenViewModel(interactor = get(), detailInteractor = get())
    }

}