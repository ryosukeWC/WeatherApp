package com.practice.weather.data.model

data class Hourly(

    val temperatureList: List<Double?>? = null,

    val relativeHumidityList: List<Int?>? = null,

    val time: List<String?>? = null
)