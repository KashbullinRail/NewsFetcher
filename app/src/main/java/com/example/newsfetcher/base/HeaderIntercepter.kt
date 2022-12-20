package com.example.newsfetcher.base

import com.example.newsfetcher.di.API_KEY
import okhttp3.Interceptor
import okhttp3.Response


class HeaderIntercepter : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        builder.addHeader("x-api-key", API_KEY)
        return chain.proceed(builder.build())
    }

}