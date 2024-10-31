package com.practice.weatherapi.dto


import com.google.gson.annotations.SerializedName

data class CurrentUnits(
    @SerializedName("interval")
    val interval: String?,
    @SerializedName("temperature_2m")
    val temperature2m: String?,
    @SerializedName("time")
    val time: String?
)