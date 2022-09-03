package com.example.newsfetcher.feature.bookmarks.di

import com.example.newsfetcher.feature.bookmarks.data.local.BookmarksLocalSource
import com.example.newsfetcher.feature.bookmarks.data.local.BookmarksRepository
import com.example.newsfetcher.feature.bookmarks.data.local.BookmarksRepositoryImpl
import com.example.newsfetcher.feature.bookmarks.domian.BookmarksInteractor
import com.example.newsfetcher.feature.bookmarks.ui.BoolmarksScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

const val BOOKMARKS_TABLE = "BOOKMARKS_TABLE"

val bookmarksModule = module {

    single {
        BookmarksLocalSource(bookmarksDao = get())
    }

    single<BookmarksRepository> {
        BookmarksRepositoryImpl(bookmarksLocalSource =  get())
    }

    single {
        BookmarksInteractor(bookmarksRepository =  get())
    }

    viewModel {
        BoolmarksScreenViewModel(interactor =  get())
    }


}