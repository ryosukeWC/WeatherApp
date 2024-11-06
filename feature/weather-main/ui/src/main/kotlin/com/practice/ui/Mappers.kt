package com.practice.ui

import com.practice.ui.model.CurrentUi
import com.practice.ui.model.WeatherDataUi
import com.practice.weather.data.model.WeatherData

fun WeatherData.toWeatherDataUi() : WeatherDataUi {

    val currentUi = CurrentUi(current.temperature2m)

    return WeatherDataUi(currentUi)
}