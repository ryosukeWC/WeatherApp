package com.practice.weather.data.di

import com.practice.weather.common.di.IoDispatcher
import com.practice.weather.data.repository.WeatherRepository
import com.practice.weatherapi.WeatherApi
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
    fun provideRepository(api : WeatherApi, @IoDispatcher ioDispatcher: CoroutineDispatcher) : WeatherRepository = WeatherRepository(api,ioDispatcher)
}