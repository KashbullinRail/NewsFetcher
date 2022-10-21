package com.example.newsfetcher

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MyJson(
    val data: List<Data>,
    val success: Boolean
) {
    @Serializable
    data class Data(val balance: String)
}
