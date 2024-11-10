package com.practice.ui

import com.practice.ui.model.CurrentUi
import com.practice.ui.model.HourlyItem
import com.practice.ui.model.HourlyUi
import com.practice.ui.model.WeatherDataUi
import com.practice.weather.data.model.WeatherData

fun WeatherData.toWeatherDataUi() : WeatherDataUi {

    val currentUi = CurrentUi(current.temperature2m)

    val hourlyUi = HourlyUi(
        temperatureList = hourly.temperatureList ?: emptyList(),
        relativeHumidityList = hourly.temperatureList ?: emptyList(),
        time = hourly.time ?: emptyList()
    )

    return WeatherDataUi(currentUi,hourlyUi)
}

fun HourlyUi.toListHourlyItem() : List<HourlyItem> {
    return temperatureList.mapIndexed { index, temperature ->
        val humidity = relativeHumidityList.getOrNull(index)
        val time = time.getOrNull(index)

        HourlyItem(
            temperature = temperature?.toString() ?: "N/A",
            humidity = humidity?.toString() ?: "N/A",
            time = time ?: "N/A"
        )
    }
}