package com.example.newsfetcher.feature.main_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel
import retrofit2.http.*


interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getArticles(
        @Query("country") country: String = "ru",
//        @Query("language") language: String = "ru",
//        @Query("category") category: String = "general", // business, entertainment, general, health, science, sports, technology
//        @Query("sources") sources: String = "",
//        @Query("q") query: String = "Путин",
//        @Query("pageSize") pageSize: String = "100", // 1..100
//        @Query("page") page: String = "" // 1
    ): ArticlesRemoteModel

//    @GET("v2/everything")
//    suspend fun getArticles(
//        @Query("q") query: String = "россия",
//        @Query("searchIn") searchIn: String = "title", // title, description, content
////        @Query("sources") sources: String = "ru",  // tr, us
////        @Query("domains") domain: String = "", //eg bbc.co.uk,
//        @Query("from") from: String = "2022-12-20",
//        @Query("to") to: String = "2022-12-18",
////        @Query("language") language: String = "ru", // en
////        @Query("sortBy") sortBy: String = "popularity", // relevancy, popularity, publishedAt
////        @Query("pageSize") pageSize: String = "100", // 1..100
////        @Query("page") page: String = "" // 1
//    ): ArticlesRemoteModel


   // This endpoint returns the subset of news publishers that top headlines
//    @GET("v2/top-headlines/source")
//    suspend fun getArticles(
//        @Query("category") category: String = "", // business, entertainment, general, health, science, sports, technology
//        @Query("language") language: String = "ru",
//        @Query("country") country: String = "ru"
//    ): ArticlesRemoteModel

}