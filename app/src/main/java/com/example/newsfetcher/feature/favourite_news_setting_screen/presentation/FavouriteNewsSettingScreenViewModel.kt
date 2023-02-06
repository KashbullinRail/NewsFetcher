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
        favouriteNews = FavouriteNews.general.str,
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DateEvent.LoadFavouriteNewsSetting -> {
                if (articlesInteractor.getFavouriteNews().favouriteNews.equals("")) {
                   return previousState.copy(
                        favouriteNews = FavouriteNews.general.str,
                        state = State.Content,
                    )
                } else {
                   return previousState.copy(
                        favouriteNews = articlesInteractor.getFavouriteNews().favouriteNews,
                        state = State.Content
                    )
                }
            }
            is UIEvent.OnSetFavouriteNewsSettingClicked -> {
                val setFavouriteNews = SetFavouriteNewsSettingModel(
                    favouriteNews = previousState.favouriteNews,
                )
                articlesInteractor.setFavouriteNews(setFavouriteNews)
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

