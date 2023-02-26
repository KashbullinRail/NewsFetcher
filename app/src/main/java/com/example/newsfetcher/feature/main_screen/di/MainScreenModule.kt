package com.example.newsfetcher.feature.main_screen.di

import com.example.newsfetcher.feature.main_screen.data.ArticlesRemoteSource
import com.example.newsfetcher.feature.main_screen.domian.ArticlesRepository
import com.example.newsfetcher.feature.main_screen.data.NewsAPI
import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteRepositoryImpl
import com.example.newsfetcher.feature.main_screen.domian.ArticlesInteractor
import com.example.newsfetcher.feature.main_screen.presentation.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val mainScreenModule = module {

    single<NewsAPI> {
        get<Retrofit>().create(NewsAPI::class.java)
    }

    single<ArticlesRepository> {
        ArticlesRemoteRepositoryImpl(source = get())
    }

    single<ArticlesRemoteSource> {
        ArticlesRemoteSource(api = get())
    }

    single<ArticlesInteractor> {
        ArticlesInteractor(repository = get())
    }

    viewModel {
        MainScreenViewModel(articleInteractor = get(), bookmarksInteractor = get())
    }

}