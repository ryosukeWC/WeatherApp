package com.example.network.location_api

import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApi {

    @GET("cities/autocomplete")
    suspend fun autoCompleteCities(@Query("q") query : String, @Query("language") language: String)
}

fun LocationApi(
    baseUrl : String,
    okHttpClient: OkHttpClient
) : LocationApi {
    return getRetrofitInstance(baseUrl, okHttpClient).create(LocationApi::class.java)
}

private fun getRetrofitInstance(baseUrl: String, okHttpClient: OkHttpClient) : Retrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .build()
    return retrofit
}