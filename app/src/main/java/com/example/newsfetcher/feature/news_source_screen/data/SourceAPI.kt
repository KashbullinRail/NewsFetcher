package com.example.newsfetcher.feature.news_source_screen.data

import com.example.newsfetcher.feature.news_source_screen.data.model.SourcesRemoteModel
import retrofit2.http.*


interface SourceAPI {

    @GET("v2/top-headlines/sources")
    suspend fun getArticles(
        @Query("category") category: String = "", // business, entertainment, general, health, science, sports, technology
        @Query("language") language: String = "",   //ru, en
//        @Query("country") country: String = "ru"
    ): SourcesRemoteModel

}