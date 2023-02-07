package com.example.newsfetcher.feature.news_source_screen.domain

import com.example.newsfetcher.base.attempt

class Interactor(private val sourcesRepository: SourcesRepository) {

    suspend fun getSources() = attempt {
        sourcesRepository.getSources()
    }

}