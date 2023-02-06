package com.example.newsfetcher.feature.favourite_news_setting_screen.presentation

import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.main_screen.domian.ArticlesInteractor


class FavouriteNewsSettingScreenViewModel(
    val articlesInteractor: ArticlesInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadFavouriteNewsSetting)
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        favouriteNews = "general",
//        business = false,
//        entertainment = false,
//        general = false,
//        health = false,
//        science = false,
//        sports = false,
//        technology = false,
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DateEvent.LoadFavouriteNewsSetting -> {
                return previousState.copy(

                    state = State.Content
                )
            }
            is UIEvent.OnSetFavouriteNewsSettingClicked -> {
                val setFavouriteNews = FavouriteNewsSettingModel(
                    favouriteNews = previousState.favouriteNews,

                )
//                searchInteractor.setSearchSetting(setSearchSetting)
                return null
            }
            is UIEvent.OnBusinessClicked -> {
                return previousState.copy(
                    favouriteNews = FavouriteNews.business.str,
                    state = State.Content
                )
            }
            is UIEvent.OnEntertainmentClicked -> {
                return previousState.copy(
                   favouriteNews = FavouriteNews.entertaiment.str,
                    state = State.Content
                )
            }
            is UIEvent.OnGeneralClicked -> {
                return previousState.copy(
                    favouriteNews = FavouriteNews.general.str,
                    state = State.Content
                )
            }
            is UIEvent.OnHealthClicked -> {
                return previousState.copy(
                    favouriteNews = FavouriteNews.health.str,
                    state = State.Content
                )
            }
            is UIEvent.OnScienceClicked -> {
                return previousState.copy(
                    favouriteNews = FavouriteNews.science.str,
                    state = State.Content
                )
            }
            is UIEvent.OnSportsClicked -> {
                return previousState.copy(
                    favouriteNews = FavouriteNews.sports.str,
                    state = State.Content
                )
            }
            is UIEvent.OnTechnologyClicked -> {
                return previousState.copy(
                    favouriteNews = FavouriteNews.technology.str,
                    state = State.Content
                )
            }

            else -> return null
        }

    }

}

