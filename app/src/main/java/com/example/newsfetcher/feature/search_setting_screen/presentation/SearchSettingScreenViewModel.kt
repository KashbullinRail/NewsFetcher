package com.example.newsfetcher.feature.search_setting_screen.presentation

import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.search_setting_screen.data.model.DataStoreSettingModel


class SearchSettingScreenViewModel() : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadArticles(""))
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        searchSetting = DataStoreSettingModel(
            "", "", "", "",
            "", "", ""
        )
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        return null
    }

}