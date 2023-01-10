package com.example.newsfetcher.feature.search_setting_screen.presentation

import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event


class SearchSettingScreenViewModel() : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadArticles(""))
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        titleSearchIn = false,
        descriptionSearchIn = false,
        allSearchIn = true,
        relevancy = false,
        publishedAt = true,
        popularity = false,
        dataFrom = "",
        dataTo = ""
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is UIEvent.OnTitleSearchInClicked -> {
                return previousState.copy(
                    titleSearchIn = true,
                    descriptionSearchIn = false,
                    allSearchIn = false,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnDescriptionSearchInClicked -> {
                return previousState.copy(
                    titleSearchIn = false,
                    descriptionSearchIn = true,
                    allSearchIn = false,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnAllSearchInClicked -> {
                return previousState.copy(
                    titleSearchIn = false,
                    descriptionSearchIn = false,
                    allSearchIn = true,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnPopularityClicked -> {
                return previousState.copy(
                    popularity = true,
                    relevancy = false,
                    publishedAt = false,
                    state = State.ContentSortBy
                )
            }
            is UIEvent.OnRelevancyClicked -> {
                return previousState.copy(
                    popularity = false,
                    relevancy = true,
                    publishedAt = false,
                    state = State.ContentSortBy
                )
            }
            is UIEvent.OnPublishedAtClicked -> {
                return previousState.copy(
                    popularity = false,
                    relevancy = false,
                    publishedAt = true,
                    state = State.ContentSortBy
                )
            }
            else -> return null
        }

    }

}