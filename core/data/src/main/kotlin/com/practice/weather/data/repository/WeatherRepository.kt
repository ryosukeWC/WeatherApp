package com.practice.weather.data.repository

import com.practice.weather.common.di.IoDispatcher
import com.practice.weather.data.RequestResult
import com.practice.weather.data.model.WeatherData
import com.practice.weather.data.toRequestResultWeatherData
import com.example.network.weather_api.WeatherApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api : com.example.network.weather_api.WeatherApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getWeatherFromServer(latitude : Double, longitude : Double) : RequestResult<WeatherData> {
        return withContext(ioDispatcher) {
            api.getData(latitude,longitude).toRequestResultWeatherData()
        }
    }
}