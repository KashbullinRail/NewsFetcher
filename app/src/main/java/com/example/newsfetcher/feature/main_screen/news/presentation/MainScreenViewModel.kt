package com.example.newsfetcher.feature.main_screen.news.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.bookmarks_screen.domian.BookmarksInteractor
import com.example.newsfetcher.feature.main_screen.news.data.ArticleModel
import com.example.newsfetcher.feature.main_screen.news.domian.ArticlesInteractor
import kotlinx.coroutines.launch


class MainScreenViewModel(
    private val articleInteractor: ArticlesInteractor,
    private val bookmarksInteractor: BookmarksInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DateEvent.LoadArticles)
    }

    override fun initialViewState() = ViewState(
        state = State.Load,
        articlesList = emptyList(),
        articlesShown = emptyList(),
        articleDetail = ArticleModel(
            "", "", "", "", "", "",
            "", "", "", false
        )
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DateEvent.LoadArticles -> {
                viewModelScope.launch {
                    articleInteractor.getArticles().fold(
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
                return previousState.copy(
                    articlesList = event.articles,
                    articlesShown = event.articles,
                    state = State.Content
                )
            }
            is UIEvent.OnArticleClicked -> {
                when (event.type) {
                    ARTICLE_ITEM -> {
                        return previousState.copy(
                            articleDetail = previousState.articlesShown[event.index],
                            state = State.DetailLoad
                        )
                    }
                    BOOKMARK_EMPTY -> {
                        viewModelScope.launch {
                            bookmarksInteractor.create(previousState.articlesShown[event.index])
                        }
                        return previousState.copy(
                            articlesList = previousState.articlesList,
                            articlesShown = previousState.articlesShown,
                            state = State.Content
                        )
                    }
                    BOOKMARK_FULL -> {
                        viewModelScope.launch {
                            bookmarksInteractor.delete(previousState.articlesShown[event.index])
                        }
                        return previousState.copy(
                            articlesList = previousState.articlesList,
                            articlesShown = previousState.articlesShown,
                            state = State.Content
                        )
                    }
                }
                return null
            }
            else -> return null
        }

    }

}