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

    private val _queryState = MutableStateFlow<String>("")
    val queryState : StateFlow<String> = _queryState

    fun fetchCities(queryCity : String) {
        viewModelScope.launch {
            citiesRepository.requestCitiesFromServer(queryCity)
                .catch { e ->
                    Log.e("HttpException", e.message.toString())
                }
                .collect { cities ->
                    _citiesState.value = cities
                }
        }
    }

}