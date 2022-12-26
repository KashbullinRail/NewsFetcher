package com.example.newsfetcher.feature.main_screen.data

import com.example.newsfetcher.feature.main_screen.data.model.ArticlesRemoteModel
import retrofit2.http.*


interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getArticles(
        @Query("country") country: String = "ru"
    ): ArticlesRemoteModel


}