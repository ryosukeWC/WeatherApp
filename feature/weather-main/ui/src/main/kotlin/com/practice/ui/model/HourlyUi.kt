package com.practice.ui.model


data class HourlyUi(

    val temperatureList: List<Double?>,

    val relativeHumidityList: List<Double?>,

    val time: List<String?>
)