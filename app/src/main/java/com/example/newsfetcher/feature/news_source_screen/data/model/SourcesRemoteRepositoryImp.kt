package com.example.newsfetcher.feature.news_source_screen.data.model

import com.example.newsfetcher.feature.news_source_screen.data.SourcesRemoteSource
import com.example.newsfetcher.feature.news_source_screen.data.toDomain
import com.example.newsfetcher.feature.news_source_screen.domain.SourceModel
import com.example.newsfetcher.feature.news_source_screen.domain.SourcesRepository
import com.example.newsfetcher.feature.source_setting_screen.presentation.model.SetSourceSettingModel

class SourcesRemoteRepositoryImp(private val source: SourcesRemoteSource): SourcesRepository {

    override suspend fun getSources(): List<SourceModel> {
        return source.getSources().sourcesList.map {
            it.toDomain()
        }
    }

    override fun setSourceSetting(setSourceSettingModel: SetSourceSettingModel) {
        source.setSourceSetting(setSourceSettingModel)
    }

    override fun getSourceSetting(): SetSourceSettingModel {
       return source.getSourceSetting()
    }


}