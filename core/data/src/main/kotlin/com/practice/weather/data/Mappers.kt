package com.practice.weather.data

import com.example.network.weather_api.dto.WeatherDataDTO
import com.practice.weather.data.model.weather.Current
import com.practice.weather.data.model.weather.Hourly
import com.practice.weather.data.model.weather.WeatherData

fun WeatherDataDTO.toWeatherData() : WeatherData {

    val current = Current(
        temperature2m = currentDTO?.temperature2m ?: 22.1
    )
    val hourly = Hourly(
        temperatureList = hourlyDTO?.temperatureList ?: emptyList(),
        relativeHumidityList = hourlyDTO?.relativeHumidityList ?: emptyList(),
        time = hourlyDTO?.time ?: emptyList()
    )
    return WeatherData(current,hourly)
}

fun Result<WeatherDataDTO>.toRequestResultWeatherData() : RequestResult<WeatherData> {
    return when {
        isSuccess -> RequestResult.Success(this.getOrNull()?.toWeatherData())
        isFailure -> RequestResult.Error(this.exceptionOrNull()?.message)
        else -> error("Error in request")
    }
}