package com.example.newsfetcher.feature.news_source_screen.di

import com.example.newsfetcher.feature.news_source_screen.data.SourceAPI
import com.example.newsfetcher.feature.news_source_screen.data.SourcesRemoteSource
import com.example.newsfetcher.feature.news_source_screen.data.model.SourcesRemoteRepositoryImp
import com.example.newsfetcher.feature.news_source_screen.domain.SourcesInteractor
import com.example.newsfetcher.feature.news_source_screen.domain.SourcesRepository
import com.example.newsfetcher.feature.news_source_screen.presentation.NewsSourceScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val sourceScreenModule = module {

    single<SourceAPI> {
        get<Retrofit>().create(SourceAPI::class.java)
    }

    single<SourcesRepository> {
        SourcesRemoteRepositoryImp(source = get())
    }

    single<SourcesRemoteSource> {
        SourcesRemoteSource(api = get())
    }

    single<SourcesInteractor> {
        SourcesInteractor(sourcesRepository = get())
    }

    viewModel {
        NewsSourceScreenViewModel(sourcesInteractor = get())
    }

}