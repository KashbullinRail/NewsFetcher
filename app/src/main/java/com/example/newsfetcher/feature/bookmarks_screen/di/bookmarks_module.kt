package com.example.newsfetcher.feature.bookmarks_screen.di

import com.example.newsfetcher.feature.bookmarks_screen.data.BookmarksLocalSource
import com.example.newsfetcher.feature.bookmarks_screen.data.BookmarksRepository
import com.example.newsfetcher.feature.bookmarks_screen.data.model.BookmarksRepositoryImpl
import com.example.newsfetcher.feature.bookmarks_screen.domian.BookmarksInteractor
import com.example.newsfetcher.feature.bookmarks_screen.presentation.BookmarksScreenViewModel
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
        BookmarksScreenViewModel(bookmarksInteractor = get(), detailInteractor = get())
    }

}