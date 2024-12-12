package com.example.network.okhttpclient

import com.example.network.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun locationOkHttpClient() : OkHttpClient {

    val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
        .addNetworkInterceptor(httpLoggingInterceptor)
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val originalUrl = originalRequest.url
            val newUrlWithApiKey = originalUrl.newBuilder().addQueryParameter("apikey",BuildConfig.API_KEY).build() // BuildConfig
            val requestWithApiKey = originalRequest.newBuilder().url(newUrlWithApiKey).build()
            chain.proceed(requestWithApiKey)
        }
        .build()

    return client
}