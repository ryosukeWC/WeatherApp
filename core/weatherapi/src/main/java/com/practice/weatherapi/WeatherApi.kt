package com.practice.weatherapi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherApi {
    @GET
    fun get() {

    }
}

fun WeatherApi(
    baseUrl : String,
    okHttpClient: OkHttpClient
) : WeatherApi {
    return getRetrofitInstance(baseUrl, okHttpClient).create(WeatherApi::class.java)
}

private fun getRetrofitInstance(baseUrl: String, okHttpClient: OkHttpClient) : Retrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit
}