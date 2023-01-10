package com.example.newsfetcher.can_be_deleted

import com.google.gson.annotations.SerializedName


data class SampleModel(
    @SerializedName("country")
    val country: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("list")
    val list: List<String>
)