package com.example.newsfetcher.feature.main_screen.di


const val BASE_URL_NEWS_API = "https://newsapi.org/"
const val API_KEY_TO_NEWS_API: String = "8d8a631cc60f433ab84de75d98294065"

enum class URL(
    val url: String
) {
    NEWS_URL("https://newsapi.org"),
    WEATHER_URL("https://api.openweathermap.org/data/2.5/")
}

enum class API_KEY(
    val apiKey: String
) {
    NEWS_API_KEY("8d8a631cc60f433ab84de75d98294065"),
    WEATHER_API_KEY("9ba2ce61cb10f2189007b0331863bb3a")
}

enum class HEADER(
    val header: String
) {
    NEWS_HEADER("x-api-key"),
    WEATHER_HEADER("appid")
}

var setUrl = URL.NEWS_URL.url
var setHeader = HEADER.WEATHER_HEADER.header
var setApiKey = API_KEY.WEATHER_API_KEY.apiKey




fun setUrl(str: String) {
    println("SETSETDSET= $setHeader  = $setApiKey")
    if (str.equals("1")) {
        setUrl = URL.NEWS_URL.url
        setHeader = HEADER.NEWS_HEADER.header
        setApiKey = API_KEY.NEWS_API_KEY.apiKey
    } else {
        setHeader = HEADER.WEATHER_HEADER.header
        setApiKey = API_KEY.WEATHER_API_KEY.apiKey
    }
    println("SETTESSETTES= $setHeader  = $setApiKey")
}

