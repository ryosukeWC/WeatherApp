package com.practice.weatherapi

import okhttp3.OkHttpClient
import retrofit2.http.GET

interface WeatherApi {
    @GET
    fun get() {

    }
}


fun getWeatherApi(
    baseUrl : String,
    okHttpClient: OkHttpClient
) : WeatherApi {

}