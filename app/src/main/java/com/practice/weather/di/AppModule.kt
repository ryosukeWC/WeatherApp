package com.practice.weather.di

import com.practice.weatherapi.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideWeatherApi(okHttpClient: OkHttpClient) : WeatherApi = WeatherApi(
        "",
        okHttpClient
    )

    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient = com.practice.weatherapi.OkHttpClient()
}