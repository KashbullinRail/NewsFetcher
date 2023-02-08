package com.example.newsfetcher.feature.news_source_screen.presentation

import com.example.newsfetcher.base.BaseViewModel
import com.example.newsfetcher.base.Event
import com.example.newsfetcher.feature.detail_screen.presentation.ViewState

class NewsSourceScreenViewModel(): BaseViewModel<ViewState>() {

   init {
       DateEvent.LoadSources
   }




    override fun initialViewState(): ViewState {
        TODO("Not yet implemented")
    }






    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        TODO("Not yet implemented")
    }




}