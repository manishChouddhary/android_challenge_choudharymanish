package com.manish.carshopee.network

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor(private val key: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url.newBuilder().addQueryParameter(
            "wa_key",
            key
        ).build()
        return chain.proceed(chain.request().newBuilder().url(url).build())
    }
}