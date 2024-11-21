package com.practice.ui.logic.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.ui.logic.State
import com.practice.ui.logic.toUiState
import com.practice.weather.data.location.LocationTracker
import com.practice.weather.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val weatherRepository : WeatherRepository,
    private val locationTracker: LocationTracker
): ViewModel() {

    private val _state = MutableStateFlow<State>(State.None)
    val state : StateFlow<State> = _state

    fun fetchData() {

        _state.value = State.Loading

        viewModelScope.launch {
            val location = locationTracker.getLocation()
            location?.let {
                _state.value = weatherRepository.getWeatherFromServer(latitude = it.latitude, longitude = it.longitude).toUiState()
            } ?: kotlin.run {
              _state.value = State.Error("Not access to gls location")
            }
        }
    }
}