package com.example.newsfetcher.feature.news_source_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel
import com.example.newsfetcher.feature.news_source_screen.data.model.SourcesRemoteModel
import retrofit2.http.*


interface SourceAPI {

//    @GET("v2/top-headlines")
//    suspend fun getArticles(
//        @Query("country") country: String = "ru",
////        @Query("language") language: String = "ru",
//        @Query("category") category: String = "", // business, entertainment, general, health, science, sports, technology
////        @Query("sources") sources: String = "",
////        @Query("q") query: String = "Путин",
////        @Query("pageSize") pageSize: String = "100", // 1..100
////        @Query("page") page: String = "" // 1
//    ): ArticlesRemoteModel

    @GET("v2/top-headlines/source")
    suspend fun getArticles(
        @Query("category") category: String = "", // business, entertainment, general, health, science, sports, technology
        @Query("language") language: String = "",   //ru, en
//        @Query("country") country: String = "ru"
    ): SourcesRemoteModel

}