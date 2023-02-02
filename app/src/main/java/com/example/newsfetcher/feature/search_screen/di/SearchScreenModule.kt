package com.example.newsfetcher.feature.search_screen.di

import com.example.newsfetcher.feature.search_screen.data.*
import com.example.newsfetcher.feature.search_screen.data.model.ArticlesSearchRemoteRepositoryImpl
import com.example.newsfetcher.feature.search_screen.domain.ArticlesSearchRepository
import com.example.newsfetcher.feature.search_screen.domain.SearchInteractor
import com.example.newsfetcher.feature.search_screen.presentation.SearchScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val searchScreenModule = module {

    single<SearchNewsAPI> {
        get<Retrofit>().create(SearchNewsAPI::class.java)
    }

    single<ArticlesSearchRepository> {
        ArticlesSearchRemoteRepositoryImpl(source = get())
    }

    single<SearchArticlesRemoteSource> {
        SearchArticlesRemoteSource(api = get())
    }

    single<SearchInteractor> {
        SearchInteractor(repository = get())
    }

    viewModel {
       SearchScreenViewModel(searchInteractor = get(), bookmarksInteractor = get())
    }

}