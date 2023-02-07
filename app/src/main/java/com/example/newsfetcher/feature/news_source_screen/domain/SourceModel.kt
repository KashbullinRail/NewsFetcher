package com.example.newsfetcher.feature.news_source_screen.domain

import java.io.Serializable

data class SourceModel(
    val id: String,
    val name: String,
    val description: String,
    val url: String,
    var selectSource: Boolean
): Serializable