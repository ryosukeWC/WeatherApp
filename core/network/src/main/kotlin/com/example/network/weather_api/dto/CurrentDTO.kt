package com.example.network.weather_api.dto


import com.google.gson.annotations.SerializedName

data class CurrentDTO(
    @SerializedName("interval")
    val interval: Int?,
    @SerializedName("temperature_2m")
    val temperature2m: Double?,
    @SerializedName("time")
    val time: String?
)