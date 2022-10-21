package com.example.newsfetcher.feature.domian

import android.util.Log
import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.data.ArticlesRepository
import com.google.gson.Gson
import com.google.gson.JsonObject

class ArticlesInteractor(private val repository: ArticlesRepository) {
    suspend fun getArticles() = attempt {


        val gson = Gson()
        val request = gson.toJson(JsonObject().apply {
            addProperty("count", "5")
            addProperty("country", "ru")
            addProperty("list", gson.toJson(listOf(1, 2, 3)))
        })
        Log.e("TAG1", request)


        repository.getArticles()

    }

}