package com.example.newsfetcher.feature.search_setting_screen.presentation

import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.search_setting_screen.data.model.DataStoreSettingModel


enum class State {
    Load,
    Content,
    DataPickerLoad,
    Error
}

data class ViewState(
    val state: State,
    val searchSetting: DataStoreSettingModel
)

sealed class UIEvent : Event {


    data class OnArticleClicked(val index: Int, val type: String) : UIEvent()
    data class OnSearchButtonClicked(val searchText: String) : UIEvent()
}

sealed class DateEvent : Event {


    data class LoadArticles(val searchText: String) : DateEvent()
    data class OnLoadArticlesSucceed(val searchSetting: DataStoreSettingModel) : DateEvent()
}