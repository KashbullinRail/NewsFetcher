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
                    searchIn = SearchIn.TITLE.toString(),
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnDescriptionSearchInClicked -> {
                return previousState.copy(
                    searchIn = SearchIn.DISCRIPTION.toString(),
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnAllSearchInClicked -> {
                return previousState.copy(
                    searchIn = SearchIn.ALL_IN.toString(),
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnPopularityClicked -> {
                return previousState.copy(
                    sortBy = SortBy.POPULARITY.toString(),
                    state = State.ContentSortBy
                )
            }
            is UIEvent.OnRelevancyClicked -> {
                return previousState.copy(
                    sortBy = SortBy.RELEVANCY.toString(),
                    state = State.ContentSortBy
                )
            }
            is UIEvent.OnPublishedAtClicked -> {
                return previousState.copy(
                    sortBy = SortBy.PUBLISHEDAT.toString(),
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

}

