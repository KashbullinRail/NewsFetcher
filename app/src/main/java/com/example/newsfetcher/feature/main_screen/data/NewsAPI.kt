package com.example.newsfetcher.feature.main_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel
import org.intellij.lang.annotations.Language
import retrofit2.http.*
import java.security.ProtectionDomain


interface NewsAPI {

//    @GET("v2/top-headlines")
//    suspend fun getArticles(
//        @Query("country") country: String = "ru",
//        @Query("language") language: String = "ru",
//        @Query("category") category: String = "general",
//        @Query("sources") sources: String = "",
//        @Query("q") query: String = "канделаки",
//        @Query("pageSize") pageSize: String = "",
//        @Query("page") page: String = ""
//    ): ArticlesRemoteModel

    @GET("v2/everything")
    suspend fun getArticles(
        @Query("q") query: String = "москвич",
//        @Query("sources") sources: String = "",
//        @Query("domains") domain: String = "",
//        @Query("from") from: String = "",
//        @Query("to") to: String = "",
//        @Query("language") language: String = "ru",
//        @Query("sortBy") sortBy: String = "",
//        @Query("pageSize") pageSize: String = "",
//        @Query("page") page: String = ""
    ): ArticlesRemoteModel


//    @GET("v2/source")
//    suspend fun getArticles(
//        @Query("category") category: String = "канделаки",
//        @Query("language") language: String = "ru",
//        @Query("country") country: String = "ru"
//    ): ArticlesRemoteModel

}