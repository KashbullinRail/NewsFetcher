package com.example.newsfetcher.feature.search_setting_screen.presentation

import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.search_screen.domain.SearchInteractor
import com.example.newsfetcher.feature.search_setting_screen.presentation.date_set_screen.model.SearchSettingModel



class SearchSettingScreenViewModel(
    val searchInteractor: SearchInteractor
) : BaseViewModel<ViewState>() {

    init {
//        processDataEvent(DateEvent.LoadArticles(""))
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
        dataTo = "",
        searchIn = "",
        sortBy = ""
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {

            is UIEvent.OnSetSearchSettingClicked -> {
                val setSearchSetting = SearchSettingModel(
                    searchIn = previousState.searchIn,
                    sortBy = previousState.sortBy,
                    dateFrom = previousState.dataFrom,
                    dateTo = previousState.dataTo
                )
                searchInteractor.setSearchSetting(setSearchSetting)
                return null
            }
            is UIEvent.OnTitleSearchInClicked -> {
                return previousState.copy(
                    titleSearchIn = true,
                    descriptionSearchIn = false,
                    allSearchIn = false,
                    searchIn = TITLE,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnDescriptionSearchInClicked -> {
                return previousState.copy(
                    titleSearchIn = false,
                    descriptionSearchIn = true,
                    allSearchIn = false,
                    searchIn = DISCRIPTION,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnAllSearchInClicked -> {
                return previousState.copy(
                    titleSearchIn = false,
                    descriptionSearchIn = false,
                    allSearchIn = true,
                    searchIn = ALL_IN,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnPopularityClicked -> {
                return previousState.copy(
                    popularity = true,
                    relevancy = false,
                    publishedAt = false,
                    sortBy = POPULARITY,
                    state = State.ContentSortBy
                )
            }
            is UIEvent.OnRelevancyClicked -> {
                return previousState.copy(
                    popularity = false,
                    relevancy = true,
                    publishedAt = false,
                    sortBy = RELEVANCY,
                    state = State.ContentSortBy
                )
            }
            is UIEvent.OnPublishedAtClicked -> {
                return previousState.copy(
                    popularity = false,
                    relevancy = false,
                    publishedAt = true,
                    sortBy = PUBLISHEDAT,
                    state = State.ContentSortBy
                )
            }
            is UIEvent.OnDataFromClicked -> {
                return previousState.copy(
                    dataFrom = event.dateFrom,
                    state = State.ContentDateFrom,
                )
            }
            is UIEvent.OnDataToClicked -> {
                return previousState.copy(
                    dataTo = event.dateTo,
                    state = State.ContentDateTo,
                )
            }

            else -> return null
        }

    }

    companion object {
        private const val TITLE = "title"
        private const val DISCRIPTION = "description"
        private const val ALL_IN = "title,description,content"

        private const val RELEVANCY = "relevancy"
        private const val POPULARITY = "popularity"
        private const val PUBLISHEDAT = "publishedAt"
    }

}

