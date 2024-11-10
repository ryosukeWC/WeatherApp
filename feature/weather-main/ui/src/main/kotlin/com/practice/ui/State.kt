package com.practice.ui

import com.practice.ui.model.WeatherDataUi
import com.practice.weather.data.RequestResult
import com.practice.weather.data.model.WeatherData

sealed class State() {

    data object None : State()

    data object Loading : State()

    data class Error(val exception : String?) : State()

    data class Success(val data : WeatherDataUi) : State()
}

fun RequestResult<WeatherData>.toUiState() : State {
    return when (this) {
        is RequestResult.Loading -> State.Loading
        is RequestResult.Success -> State.Success(data?.toWeatherDataUi()!!)
        is RequestResult.Error -> State.Error(error ?: "Unknown exception")
    }
}