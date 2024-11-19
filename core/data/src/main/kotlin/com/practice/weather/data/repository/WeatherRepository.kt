package com.practice.weather.data.repository

import com.practice.weather.data.RequestResult
import com.practice.weather.data.model.WeatherData
import com.practice.weather.data.toRequestResultWeatherData
import com.practice.weatherapi.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api : WeatherApi
) {

    suspend fun getWeatherFromServer(latitude : Double, longitude : Double) : RequestResult<WeatherData> {
        return withContext(Dispatchers.IO) {
            api.getData(latitude,longitude).toRequestResultWeatherData()
        }
    }
}