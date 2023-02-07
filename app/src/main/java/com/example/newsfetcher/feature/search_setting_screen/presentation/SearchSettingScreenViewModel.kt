package com.example.newsfetcher.feature.search_setting_screen.presentation

import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.search_screen.data.model.SearchSettingModel
import com.example.newsfetcher.feature.search_screen.domain.SearchInteractor
import java.util.*


class SearchSettingScreenViewModel(
    val searchInteractor: SearchInteractor
) : BaseViewModel<ViewState>() {

    private val init = Calendar.getInstance()
    private val year = init.get(Calendar.YEAR)
    private val prevMonth = init.get(Calendar.MONTH)
    private val day = init.get(Calendar.DAY_OF_MONTH)
    private val dayOfMonth = "$year-${prevMonth + 1}-$day"
    private val prevDayOfMonth = "$year-$prevMonth-$day"

    init {
        processDataEvent(DateEvent.LoadSearchSetting)
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        dataFrom = "",
        dataTo = "",
        searchIn = "",
        sortBy = "",
        dataType = ""
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DateEvent.LoadSearchSetting -> {
                val set = searchInteractor.getSearchSetting()
                if (set.dateFrom.equals("")) {
                    return previousState.copy(
                        searchIn = SearchIn.All_In.str,
                        dataTo = prevDayOfMonth,
                        dataFrom = dayOfMonth,
                        sortBy = SortBy.PublishedAt.str,
                        dataType = DateType.Date_All.str,
                        state = State.Content
                    )
                } else {
                    return previousState.copy(
                        searchIn = set.searchIn,
                        dataTo = set.dateTo,
                        dataFrom = set.dateFrom,
                        sortBy = set.sortBy,
                        dataType = DateType.Date_All.str,
                        state = State.Content
                    )
                }
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
                    searchIn = SearchIn.Title.str,
                    state = State.Content
                )
            }
            is UIEvent.OnDescriptionSearchInClicked -> {
                return previousState.copy(
                    searchIn = SearchIn.Discription.str,
                    state = State.Content
                )
            }
            is UIEvent.OnAllSearchInClicked -> {
                return previousState.copy(
                    searchIn = SearchIn.All_In.str,
                    state = State.Content
                )
            }
            is UIEvent.OnPopularityClicked -> {
                return previousState.copy(
                    sortBy = SortBy.Popularity.str,
                    state = State.Content
                )
            }
            is UIEvent.OnRelevancyClicked -> {
                return previousState.copy(
                    sortBy = SortBy.Relevancy.str,
                    state = State.Content
                )
            }
            is UIEvent.OnPublishedAtClicked -> {
                return previousState.copy(
                    sortBy = SortBy.PublishedAt.str,
                    state = State.Content
                )
            }
            is UIEvent.OnDataFromClicked -> {
                if (!(event.dateFrom == "") && !(event.dateFrom < prevDayOfMonth)) {
                    return previousState.copy(
                        dataFrom = event.dateFrom,
                        dataType = DateType.Date_From.str,
                        state = State.Content,
                    )
                } else {
                    return previousState.copy(
                        dataFrom = prevDayOfMonth,
                        dataType = DateType.Date_From.str,
                        state = State.Content,
                    )
                }
            }
            is UIEvent.OnDataToClicked -> {
                return previousState.copy(
                    dataTo = event.dateTo,
                    dataType = DateType.Date_To.str,
                    state = State.Content,
                )
            }
            else -> return null
        }

    }

}

