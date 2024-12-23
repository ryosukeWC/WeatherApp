package com.practice.weather.data.repository

import com.example.network.location_api.LocationApi
import com.practice.weather.common.di.IoDispatcher
import com.practice.weather.data.model.location.AdministrativeArea
import com.practice.weather.data.model.location.CityItem
import com.practice.weather.data.model.location.Country
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CitiesRepository @Inject constructor(
    private val locationApi: LocationApi,
    @IoDispatcher private val ioDispatcher : CoroutineDispatcher
) {
    fun requestCitiesFromServer(query : String) : Flow<List<CityItem>> = flow {
        emit(locationApi.autoCompleteCities(query,"ru").getOrThrow().map { item ->
            CityItem(
                administrativeArea = item.administrativeArea?.let {
                    return@let AdministrativeArea(
                        id = it.id,
                        localizedName = it.localizedName
                    )
                },
                country = item.country?.let {
                    return@let Country(
                        id = it.id,
                        localizedName = it.localizedName
                    )
                },
                key = item.key,
                localizedName = item.localizedName,
                rank = item.rank,
                type = item.type,
                version = item.version
            )
        })
    }.flowOn(ioDispatcher)
}