package com.example.newsfetcher.feature.favourite_news_setting.presentation

import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.main_screen.domian.ArticlesInteractor
import java.util.*


class FavouriteNewsSettingScreenViewModel(
    val articlesInteractor: ArticlesInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadFavouriteNewsSetting)
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        business = false,
        entertainment = false,
        general = false,
        health = false,
        science = false,
        sports = false,
        technology = false,
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DateEvent.LoadFavouriteNewsSetting -> {

                return null
            }
            is UIEvent.OnSetFavouriteNewsSettingClicked -> {
//                val setFavouriteNews = FavouriteNewsSettingModel(
//
//                )
//                searchInteractor.setSearchSetting(setSearchSetting)
                return null
            }
            is UIEvent.OnBusinessClicked -> {
                return previousState.copy(

                    state = State.Content
                )
            }
            is UIEvent.OnEntertainmentClicked -> {
                return previousState.copy(

                    state = State.Content
                )
            }
            is UIEvent.OnGeneralClicked -> {
                return previousState.copy(

                    state = State.Content
                )
            }
            is UIEvent.OnHealthClicked -> {
                return previousState.copy(

                    state = State.Content
                )
            }
            is UIEvent.OnScienceClicked -> {
                return previousState.copy(
                    state = State.Content
                )
            }
            is UIEvent.OnSportsClicked -> {
                return previousState.copy(

                    state = State.Content
                )
            }
            is UIEvent.OnTechnologyClicked -> {
                return previousState.copy(

                    state = State.Content
                )
            }

            else -> return null
        }

    }

}

