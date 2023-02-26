package com.example.newsfetcher.feature.source_setting_screen.presentation

import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.news_source_screen.domain.SourcesInteractor
import com.example.newsfetcher.feature.source_setting_screen.presentation.model.SetSourceSettingModel


class SourceNewsSettingScreenViewModel(
    val sourcesInteractor: SourcesInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadFavouriteNewsSetting)
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        sourceNews = SourceNews.general.str,
        languageNews = LanguageNews.russia.str
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DateEvent.LoadFavouriteNewsSetting -> {
                if (sourcesInteractor.getSourceSetting().sourceNews.equals("")) {
                    return previousState.copy(
                        sourceNews = SourceNews.general.str,
                        languageNews = LanguageNews.russia.str,
                        state = State.Content,
                    )
                } else {
                    return previousState.copy(
                        sourceNews = sourcesInteractor.getSourceSetting().sourceNews,
                        languageNews = sourcesInteractor.getSourceSetting().languageNews,
                        state = State.Content
                    )
                }
            }
            is UIEvent.OnSetFavouriteNewsSettingClicked -> {
                val setSourceNews = SetSourceSettingModel(
                    sourceNews = previousState.sourceNews,
                    languageNews = previousState.languageNews
                )
                sourcesInteractor.setSourceSetting(setSourceNews)
                return null
            }
            is UIEvent.OnBusinessClicked -> {
                return previousState.copy(
                    sourceNews = SourceNews.business.str,
                    state = State.Content
                )
            }
            is UIEvent.OnEntertainmentClicked -> {
                return previousState.copy(
                    sourceNews = SourceNews.entertaiment.str,
                    state = State.Content
                )
            }
            is UIEvent.OnGeneralClicked -> {
                return previousState.copy(
                    sourceNews = SourceNews.general.str,
                    state = State.Content
                )
            }
            is UIEvent.OnHealthClicked -> {
                return previousState.copy(
                    sourceNews = SourceNews.health.str,
                    state = State.Content
                )
            }
            is UIEvent.OnScienceClicked -> {
                return previousState.copy(
                    sourceNews = SourceNews.science.str,
                    state = State.Content
                )
            }
            is UIEvent.OnSportsClicked -> {
                return previousState.copy(
                    sourceNews = SourceNews.sports.str,
                    state = State.Content
                )
            }
            is UIEvent.OnTechnologyClicked -> {
                return previousState.copy(
                    sourceNews = SourceNews.technology.str,
                    state = State.Content
                )
            }
            is UIEvent.OnEnglishLanguageClicked -> {
                return previousState.copy(
                    languageNews = LanguageNews.english.str,
                    state = State.Content
                )
            }
            is UIEvent.OnRussiaLanguageClicked -> {
                return previousState.copy(
                    languageNews = LanguageNews.russia.str,
                    state = State.Content
                )
            }

            else -> return null
        }

    }

}

