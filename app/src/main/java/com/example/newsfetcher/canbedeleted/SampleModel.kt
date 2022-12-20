package com.example.newsfetcher.canbedeleted

import com.google.gson.annotations.SerializedName


data class SampleModel(
    @SerializedName("country")
    val country: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("list")
    val list: List<String>
)