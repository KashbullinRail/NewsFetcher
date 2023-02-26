package com.example.newsfetcher.feature.news_source_screen.data

import com.example.newsfetcher.feature.news_source_screen.data.model.SourcesRemoteModel
import com.example.newsfetcher.feature.source_setting_screen.presentation.model.SetSourceSettingModel


class SourcesRemoteSource(private val api: SourceAPI) {

    companion object {
       private var setTypeNews = ""
       private var setLanguage = "ru"
    }

    suspend fun getSources(): SourcesRemoteModel {
       return api.getArticles(
           category = setTypeNews,
           language = setLanguage
       )
    }

    fun setSourceSetting(setSourceSettingModel: SetSourceSettingModel) {
        setTypeNews = setSourceSettingModel.sourceNews
        setLanguage = setSourceSettingModel.languageNews
    }

    fun getSourceSetting(): SetSourceSettingModel {
        return SetSourceSettingModel(
            sourceNews = setTypeNews,
            languageNews = setLanguage
        )
    }

}