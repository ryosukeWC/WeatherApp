package com.practice.weather.data

import com.practice.weather.data.model.Current
import com.practice.weather.data.model.RequestResult
import com.practice.weather.data.model.WeatherData
import com.practice.weatherapi.dto.WeatherDataDTO

fun WeatherDataDTO.toWeatherData() : WeatherData {

    val current = Current(
        temperature2m = currentDTO?.temperature2m ?: 22.1
    )
    return WeatherData(current)
}

fun Result<WeatherDataDTO>.toRequestResultWeatherData() : RequestResult<WeatherData> {
    return when {
        isSuccess -> RequestResult.Success(this.getOrNull()?.toWeatherData())
        isFailure -> RequestResult.Error(this.exceptionOrNull()?.message)
        else -> error("Error in request")
    }
}