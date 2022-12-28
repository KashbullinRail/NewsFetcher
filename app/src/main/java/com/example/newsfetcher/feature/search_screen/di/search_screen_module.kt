package com.example.newsfetcher.feature.search_screen.di

import com.example.newsfetcher.feature.main_screen.data.ArticlesRepository
import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteRepositoryImpl
import com.example.newsfetcher.feature.search_screen.data.SearchArticlesRemoteSource
import com.example.newsfetcher.feature.search_screen.data.SearchNewsAPI
import com.example.newsfetcher.feature.search_screen.domain.SearchInteractor
import com.example.newsfetcher.feature.search_screen.presentation.SearchScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val searchScreenModule = module {

    single<SearchNewsAPI> {
        get<Retrofit>().create(SearchNewsAPI::class.java)
    }

    single<ArticlesRepository> {
        ArticlesRemoteRepositoryImpl(source = get())
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