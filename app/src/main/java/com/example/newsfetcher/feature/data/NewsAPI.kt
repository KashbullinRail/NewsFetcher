package com.example.newsfetcher.feature.data

import com.example.newsfetcher.di.API_KEY
import com.example.newsfetcher.feature.data.model.ArticleRemoteModel
import com.example.newsfetcher.feature.data.model.ArticlesRemoteModel
import retrofit2.http.*

interface NewsAPI {
    @GET("v2/top-headlines")
    suspend fun getArticles(
//        @Query("apiKey") apiKey: String = API_KEY,
        @Query("country") country :String = "ru"
    ): ArticlesRemoteModel

    @FormUrlEncoded
    @POST("v2/top-headlines")
    suspend fun postArticles(
        @Field("country") country :String = "ru"
    ): ArticlesRemoteModel
}