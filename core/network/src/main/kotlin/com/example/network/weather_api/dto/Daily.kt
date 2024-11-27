package com.example.network.weather_api.dto


import com.google.gson.annotations.SerializedName

data class Daily(
    @SerializedName("temperature_2m_max")
    val temperature2mMax: List<Double?>?,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: List<Double?>?,
    @SerializedName("time")
    val time: List<String?>?
)