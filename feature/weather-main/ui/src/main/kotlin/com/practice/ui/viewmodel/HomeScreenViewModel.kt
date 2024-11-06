package com.practice.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.ui.State
import com.practice.ui.toUiState
import com.practice.weather.data.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val weatherRepository : WeatherRepository
): ViewModel() {

    private val _state = MutableStateFlow<State>(State.None)
    val state : StateFlow<State> = _state

    init {
        fetchData()
    }

    private fun fetchData() {

        _state.value = State.Loading

        viewModelScope.launch(context = Dispatchers.IO) {
            _state.value = weatherRepository.getWeatherFromServer().toUiState()
        }
    }
}