package com.practice.weatherapi.dto


import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("interval")
    val interval: Int?,
    @SerializedName("temperature_2m")
    val temperature2m: Double?,
    @SerializedName("time")
    val time: String?
)