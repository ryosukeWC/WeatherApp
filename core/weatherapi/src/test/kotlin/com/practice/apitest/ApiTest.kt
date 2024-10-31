package com.practice.apitest

import com.practice.weatherapi.OkHttpClient
import com.practice.weatherapi.WeatherApi
import org.junit.Test

class ApiTest {

    @Test
    fun testApi() {

        val okHttpClient = OkHttpClient()

        val baseUrl = "https://api.open-meteo.com/v1/"

        val api = WeatherApi(baseUrl,okHttpClient)
    }

}