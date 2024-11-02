package com.practice.weather.data

import com.practice.weatherapi.WeatherApi
import com.practice.weatherapi.dto.WeatherData
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api : WeatherApi
) {
    suspend fun getWeatherFromServer() : Result<WeatherData> {
        return api.getData(50.5,32.5)
    }
}