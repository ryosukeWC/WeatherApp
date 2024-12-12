package com.practice.ui.logic

import com.practice.ui.logic.model.WeatherDataUi
import com.practice.weather.data.RequestResult
import com.practice.weather.data.model.weather.WeatherData

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