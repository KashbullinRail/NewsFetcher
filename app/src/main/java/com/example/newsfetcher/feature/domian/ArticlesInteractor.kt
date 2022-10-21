package com.example.newsfetcher.feature.domian

import android.util.Log
import com.example.newsfetcher.MyJson
import com.example.newsfetcher.SampleModel
import com.example.newsfetcher.base.attempt
import com.example.newsfetcher.feature.data.ArticlesRepository
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.parse

class ArticlesInteractor(private val repository: ArticlesRepository) {
    suspend fun getArticles() = attempt {


        val gson = Gson()
        val request = gson.toJson(JsonObject().apply {
            addProperty("count", "5")
            addProperty("country", "ru")
            addProperty("list", gson.toJson(listOf("1", "2", "3")))
        })
        Log.e("TAG1", request)

        val response = "{\"count\":5,\"country\":\"ru\",\"list\":[\"35573\"]}"
        val model = gson.fromJson(response, SampleModel::class.java)
        Log.e("TAG", model.toString())

        val text = "\"[\\n\" +\n" +
                "                \"{\\n\" +\n" +
                "                \"«id»: «6212577f0095c22f40b1a78a»,\\n\" +\n" +
                "                \"«email»: «fields_tyson@manglo.degree»,\\n\" +\n" +
                "                \"«roles»: [\\n\" +\n" +
                "                \"«owner»,\\n\" +\n" +
                "                \"«guest»\\n\" +\n" +
                "                \"],\\n\" +\n" +
                "                \"«apiKey»: «f767f1e7-63e2-4f7b-984d-1f4743e7dfd1»,\\n\" +\n" +
                "                \"«profile»: {\\n\" +\n" +
                "                \"«dob»: «17.02.1989»,\\n\" +\n" +
                "                \"«name»: «Fields Tyson»,\\n\" +\n" +
                "                \"«about»: «Quis labore commodo culpa aliquip cillum deserunt culpa non pariatur minim ullamco reprehenderit nulla esse. Ullamco aliquip do commodo cillum.»,\\n\" +\n" +
                "                \"«address»: «59 Menahan Street, Loretto, Washington»,\\n\" +\n" +
                "                \"«company»: «Manglo»,\\n\" +\n" +
                "                \"«location»: {\\n\" +\n" +
                "                \"«lat»: 56.740646,\\n\" +\n" +
                "                \"«long»: -60.715809\\n\" +\n" +
                "                \"}\\n\" +\n" +
                "                \"},\\n\" +\n" +
                "                \"«username»: «fields89»,\\n\" +\n" +
                "                \"«createdAt»: «09.12.2013T14:53:16.548Z»,\\n\" +\n" +
                "                \"«updatedAt»: «10.12.2013T14:53:16.548Z»\\n\" +\n" +
                "                \"}\\n\" +\n" +
                "                \"]\""

        val response2 = "{«id»: «6212577f0095c22f40b1a78a»,\n" +
                "«email»: «fields_tyson@manglo.degree»,\n" +
                "«roles»: [\n" +
                "«owner»,\n" +
                "«guest»\n" +
                "]}"
        val model2 = gson.fromJson(response2, MyJson::class.java)
        Log.e("TAG_DZ", model2.toString())

        val myJson: MyJson = Json.parse()
        Log.e("TAG_DZ", myJson.toString())

//        val myJsonText = ""
//        val myJson: MyJson = Json.parse(MyJso, myJsonText)
//        val myThingInJsonText: String = Json.stringify(MyThing.serializer(), myThing)

        repository.getArticles()

    }

}