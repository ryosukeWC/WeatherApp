package com.practice.weatherapi.dto


import com.google.gson.annotations.SerializedName

data class HourlyUnitsDTO(
    @SerializedName("temperature_2m")
    val temperature2m: String?,
    @SerializedName("relative_humidity_2m")
    val relativeHumidity2m: String?,
    @SerializedName("time")
    val time: String?
)