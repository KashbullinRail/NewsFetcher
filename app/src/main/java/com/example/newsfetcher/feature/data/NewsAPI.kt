package com.example.newsfetcher.feature.data

import com.example.newsfetcher.di.API_KEY
import com.example.newsfetcher.feature.data.model.ArticleRemoteModel
import com.example.newsfetcher.feature.data.model.ArticlesRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("v2/top-headlines")
    suspend fun getArticles(
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("country") units :String = "ru"
    ): ArticlesRemoteModel

    @POST("v2/top-headlines")
    suspend fun post2Articles(
        @Body jsonModel: JsonModel.JsonModelItem = JsonModel.JsonModelItem(
            "f767f1e7-63e2-4f7b-984d-1f4743e7dfd1",
            "09.12.2013T14:53:16.548Z",
            "fields_tyson@manglo.degree",
            "6212577f0095c22f40b1a78a",
            profile = JsonModel.JsonModelItem.Profile(
                "Quis labore commodo culpa aliquip cillum deserunt culpa non pariatur minim ullamco reprehenderit nulla esse. Ullamco aliquip do commodo cillum.",
                "59 Menahan Street, Loretto, Washington",
                "Manglo",
                "17.02.1989",
                location = JsonModel.JsonModelItem.Profile.Location(56.740646, -60.715809),
                "Fields Tyson"
            ),
            roles = listOf("owner", "guest"),
            "10.12.2013T14:53:16.548Z",
            "fields89")
    ): ArticlesRemoteModel
}