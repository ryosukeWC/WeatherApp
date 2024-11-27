package com.example.network.weather_api

import com.example.network.weather_api.dto.WeatherDataDTO
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast?current=temperature_2m&hourly=temperature_2m,relative_humidity_2m&daily=temperature_2m_max,temperature_2m_min&forecast_days=1")
    suspend fun getData(
        @Query("latitude") latitude : Double,
        @Query("longitude") longitude : Double
    ) : Result<WeatherDataDTO>
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
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .build()
    return retrofit
}