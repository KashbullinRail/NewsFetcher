package com.example.newsfetcher.feature.domian

import android.util.Log
import com.example.newsfetcher.SampleModel
import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.data.ArticlesRepository
import com.google.gson.Gson
import com.google.gson.JsonObject

class ArticlesInteractor(private val repository: ArticlesRepository) {
    suspend fun getArticles() = attempt {


//        val gson = Gson()
//        val request = gson.toJson(JsonObject().apply {
//            addProperty("count", "5")
//            addProperty("country", "ru")
//            addProperty("list", gson.toJson(listOf("1", "2", "3")))
//        })
//        Log.e("TAG1", request)
//
//        val response = "{\"count\":\"5\",\"country\":\"ru\",\"list\":\"[\\\"1\\\",\\\"2\\\",\\\"3\\\"]\"}"
//
//        val model = gson.fromJson(response, SampleModel::class.java)
//
//        Log.e("TAG", model.toString())

        repository.getArticles()

    }

//    {"count":"5","country":"ru","list":"[\"1\",\"2\",\"3\"]"}

}