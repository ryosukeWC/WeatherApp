package com.practice.weather.data

import com.practice.weather.data.model.WeatherData
import com.practice.weatherapi.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api : WeatherApi
) {
    suspend fun getWeatherFromServer() : RequestResult<WeatherData> {
        return withContext(Dispatchers.IO) {
            api.getData(50.5,32.5).toRequestResultWeatherData()
        }
    }
}