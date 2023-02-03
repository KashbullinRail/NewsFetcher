package com.example.newsfetcher.feature.search_setting_screen.presentation

import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.search_screen.data.model.SearchSettingModel
import com.example.newsfetcher.feature.search_screen.domain.SearchInteractor


class SearchSettingScreenViewModel(
    val searchInteractor: SearchInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadSearchSetting)
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        dataFrom = "",
        dataTo = "",
        searchIn = SearchIn.ALL_IN.str,
        sortBy = SortBy.RELEVANCY.str,
        dataType = ""
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {

            is DateEvent.LoadSearchSetting -> {
                val set = searchInteractor.getSearchSetting()

                return previousState.copy(
                    searchIn = set.searchIn,
                    dataTo = set.dateTo,
                    dataFrom = set.dateFrom,
                    sortBy = set.sortBy,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnSetSearchSettingClicked -> {
                val setSearchSetting = SearchSettingModel(
                    searchIn = previousState.searchIn,
                    sortBy = previousState.sortBy,
                    dateFrom = previousState.dataFrom,
                    dateTo = previousState.dataTo,
                )
                searchInteractor.setSearchSetting(setSearchSetting)
                return null
            }
            is UIEvent.OnTitleSearchInClicked -> {
                return previousState.copy(
                    searchIn = SearchIn.TITLE.str,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnDescriptionSearchInClicked -> {
                return previousState.copy(
                    searchIn = SearchIn.DISCRIPTION.str,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnAllSearchInClicked -> {
                return previousState.copy(
                    searchIn = SearchIn.ALL_IN.str,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnPopularityClicked -> {
                return previousState.copy(
                    sortBy = SortBy.POPULARITY.str,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnRelevancyClicked -> {
                return previousState.copy(
                    sortBy = SortBy.RELEVANCY.str,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnPublishedAtClicked -> {
                return previousState.copy(
                    sortBy = SortBy.PUBLISHEDAT.str,
                    state = State.ContentSearchIn
                )
            }
            is UIEvent.OnDataFromClicked -> {
                return previousState.copy(
                    dataFrom = event.dateFrom,
                    dataType = DateType.DATE_FROM.str,
                    state = State.ContentSearchIn,
                )
            }
            is UIEvent.OnDataToClicked -> {
                return previousState.copy(
                    dataTo = event.dateTo,
                    dataType = DateType.DATE_TO.str,
                    state = State.ContentSearchIn,
                )
            }

            else -> return null
        }

    }

}

