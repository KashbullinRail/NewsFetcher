package com.example.newsfetcher.feature.mainscreen

import android.util.Log
import androidx.lifecycle.*
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.domian.ArticlesInteractor
import kotlinx.coroutines.launch

class MainScreenViewModel(private val interactor: ArticlesInteractor) : BaseViewModel<ViewState>() {
    override fun initialViewState() = ViewState(articles = emptyList())

    init {
        processDataEvent(DateEvent.LoadArticles)
    }

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DateEvent.LoadArticles -> {
                viewModelScope.launch {
                    interactor.getArticles().fold(
                        onError = {
                                  Log.e("ERROR", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DateEvent.OnLoadArticlesSucceed(it))
                        }
                    )

                }
                return null
            }
            is DateEvent.OnLoadArticlesSucceed -> {
                 return previousState.copy(articles = event.articles)
            }
            else -> return null
        }

    }
}