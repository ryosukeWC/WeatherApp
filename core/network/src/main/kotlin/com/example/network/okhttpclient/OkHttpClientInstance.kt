package com.example.network.okhttpclient

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun okHttpClientInstance() : OkHttpClient {

    val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    return client
}