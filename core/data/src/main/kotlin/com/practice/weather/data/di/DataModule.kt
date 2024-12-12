package com.practice.weather.data.di

import com.example.network.location_api.LocationApi
import com.example.network.weather_api.WeatherApi
import com.practice.weather.common.di.IoDispatcher
import com.practice.weather.data.repository.CitiesRepository
import com.practice.weather.data.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(api : WeatherApi, @IoDispatcher ioDispatcher: CoroutineDispatcher) : WeatherRepository = WeatherRepository(api,ioDispatcher)

    @Singleton
    @Provides
    fun provideCitiesRepository(api : LocationApi, @IoDispatcher ioDispatcher: CoroutineDispatcher) : CitiesRepository = CitiesRepository(api,ioDispatcher)
}