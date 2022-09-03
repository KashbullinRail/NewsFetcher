package com.example.newsfetcher.feature.di

import com.example.newsfetcher.feature.data.ArticlesRemoteSource
import com.example.newsfetcher.feature.data.ArticlesRepository
import com.example.newsfetcher.feature.data.NewsAPI
import com.example.newsfetcher.feature.data.model.ArticlesRemoteRepositoryImpl
import com.example.newsfetcher.feature.domian.ArticlesInteractor
import com.example.newsfetcher.feature.mainscreen.MainScreenViewModel
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
        MainScreenViewModel(interactor = get(), bookmarksInteractor = get())
    }


}