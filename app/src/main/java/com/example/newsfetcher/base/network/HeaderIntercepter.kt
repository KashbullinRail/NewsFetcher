package com.example.newsfetcher.base.network

import com.example.newsfetcher.feature.main_screen.di.API_KEY_TO_NEWS_API
import okhttp3.Interceptor
import okhttp3.Response


class HeaderIntercepter : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
//        builder.addHeader(setHeader, setApiKey)
        builder.addHeader("x-api-key", API_KEY_TO_NEWS_API)
        return chain.proceed(builder.build())
    }

}