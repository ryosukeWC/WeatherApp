package com.practice.weather.city_search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.weather.data.model.location.CityItem
import com.practice.weather.data.repository.CitiesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesSearchViewModel @Inject constructor(
    private val citiesRepository : CitiesRepository
) : ViewModel() {

    private val _citiesState = MutableStateFlow<List<CityItem>>(emptyList())
    val citiesState: StateFlow<List<CityItem>> = _citiesState

    init {
        fetchCities()
    }

    private fun fetchCities() {
        viewModelScope.launch {
            citiesRepository.requestCitiesFromServer()
                .catch { e ->
                    Log.e("HttpException", e.message.toString())
                }
                .collect { cities ->
                    _citiesState.value = cities
                }
        }
    }

}