package com.practice.weather.di

import com.practice.weather.data.remote.okHttpClientInstance
import com.practice.weatherapi.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideWeatherApi(okHttpClient: OkHttpClient) : WeatherApi = WeatherApi(
        "https://api.open-meteo.com/v1/",
        okHttpClient
    )

    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient = okHttpClientInstance()
}