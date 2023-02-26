package com.example.newsfetcher.feature.source_setting_screen.presentation

import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.main_screen.domian.ArticlesInteractor
import com.example.newsfetcher.feature.news_source_screen.domain.SourcesInteractor


class SourceNewsSettingScreenViewModel(
    val sourcesInteractor: SourcesInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadFavouriteNewsSetting)
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        favouriteNews = SourceNews.general.str,
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DateEvent.LoadFavouriteNewsSetting -> {
                if (sourcesInteractor.getFavouriteNews().favouriteNews.equals("")) {
                   return previousState.copy(
                        favouriteNews = SourceNews.general.str,
                        state = State.Content,
                    )
                } else {
                   return previousState.copy(
                        favouriteNews = sourcesInteractor.getFavouriteNews().favouriteNews,
                        state = State.Content
                    )
                }
            }
            is UIEvent.OnSetFavouriteNewsSettingClicked -> {
                val setFavouriteNews = SetFavouriteNewsSettingModel(
                    favouriteNews = previousState.favouriteNews,
                )
                sourcesInteractor.setFavouriteNews(setFavouriteNews)
                return null
            }
            is UIEvent.OnBusinessClicked -> {
                return previousState.copy(
                    favouriteNews = SourceNews.business.str,
                    state = State.Content
                )
            }
            is UIEvent.OnEntertainmentClicked -> {
                return previousState.copy(
                    favouriteNews = SourceNews.entertaiment.str,
                    state = State.Content
                )
            }
            is UIEvent.OnGeneralClicked -> {
                return previousState.copy(
                    favouriteNews = SourceNews.general.str,
                    state = State.Content
                )
            }
            is UIEvent.OnHealthClicked -> {
                return previousState.copy(
                    favouriteNews = SourceNews.health.str,
                    state = State.Content
                )
            }
            is UIEvent.OnScienceClicked -> {
                return previousState.copy(
                    favouriteNews = SourceNews.science.str,
                    state = State.Content
                )
            }
            is UIEvent.OnSportsClicked -> {
                return previousState.copy(
                    favouriteNews = SourceNews.sports.str,
                    state = State.Content
                )
            }
            is UIEvent.OnTechnologyClicked -> {
                return previousState.copy(
                    favouriteNews = SourceNews.technology.str,
                    state = State.Content
                )
            }

            else -> return null
        }

    }

}

