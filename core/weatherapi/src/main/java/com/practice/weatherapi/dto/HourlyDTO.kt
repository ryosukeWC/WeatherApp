package com.practice.weatherapi.dto


import com.google.gson.annotations.SerializedName

data class HourlyDTO(

    @SerializedName("temperature_2m")
    val temperatureList: List<Double?>?,

    @SerializedName("relative_humidity_2m")
    val relativeHumidityList: List<Int?>?,

    @SerializedName("time")
    val time: List<String?>?
)