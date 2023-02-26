package com.example.newsfetcher.feature.news_source_screen.data.model

import com.google.gson.annotations.SerializedName


data class SourcesRemoteModel(
    @SerializedName("sources")
    val sourcesList: List<SourceRemoteModel>
)