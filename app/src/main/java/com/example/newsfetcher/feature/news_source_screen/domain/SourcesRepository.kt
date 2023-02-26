package com.example.newsfetcher.feature.news_source_screen.domain

import com.example.newsfetcher.feature.source_setting_screen.presentation.model.SetSourceSettingModel


interface SourcesRepository {

    suspend fun getSources(): List<SourceModel>

    fun setSourceSetting(setSourceSettingModel: SetSourceSettingModel)

    fun getSourceSetting(): SetSourceSettingModel

}