package com.example.newsfetcher.feature.news_source_screen.domain

import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.source_setting_screen.presentation.model.SetSourceSettingModel


class SourcesInteractor(private val sourcesRepository: SourcesRepository) {

    suspend fun getSources() = attempt {
        sourcesRepository.getSources()
    }

    fun setSourceSetting(setSourceSettingModel: SetSourceSettingModel) = attempt {
        sourcesRepository.setSourceSetting(setSourceSettingModel)
    }

    fun getSourceSetting(): SetSourceSettingModel {
        return sourcesRepository.getSourceSetting()
    }

}