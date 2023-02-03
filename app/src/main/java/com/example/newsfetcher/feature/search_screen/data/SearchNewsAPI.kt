package com.example.newsfetcher.feature.search_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel
import com.example.newsfetcher.feature.search_screen.data.model.SearchSettingModel
import retrofit2.http.*


interface SearchNewsAPI {

    @GET("v2/everything")
    suspend fun getArticles(
        @Query("q") query: String,
        @Query("searchIn") searchIn: String = "title,description,content",   // = "title,description,content", // title, description, content
//        @Query("sources") sources: String = "ru",  // tr, us
//        @Query("domains") domain: String = "", //eg bbc.co.uk,
        @Query("from") from: String = "2022-01-01",   // = "2022-12-26",
        @Query("to") to: String = "2023-01-01",      // = "2022-12-18",
//        @Query("language") language: String = "ru", // en, tr
        @Query("sortBy") sortBy: String = "publishedAt"     // = "popularity", // relevancy, popularity, publishedAt
//        @Query("pageSize") pageSize: String = "100", // 1..100
//        @Query("page") page: String = "" // 1
    ): ArticlesRemoteModel


}