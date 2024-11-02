package com.practice.apitest

import com.practice.weatherapi.OkHttpClient
import com.practice.weatherapi.WeatherApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ApiTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testApi() = runTest(UnconfinedTestDispatcher()) {

        val okHttpClient = OkHttpClient()

        val baseUrl = "https://api.open-meteo.com/v1/"

        val api = WeatherApi(baseUrl,okHttpClient)

        println(api.getData(53.2,32.5))
    }

}