package com.example.network.di

import com.example.network.BuildConfig
import com.example.network.location_api.LocationApi
import com.example.network.okhttpclient.okHttpClientInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton
import com.example.network.weather_api.WeatherApi


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideWeatherApi(okHttpClient: OkHttpClient) : WeatherApi = WeatherApi(BuildConfig.BASE_URL_WEATHER_SERVICE,okHttpClient)

    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient = okHttpClientInstance()

    @Singleton
    @Provides
    fun provideLocationApi(okHttpClient: OkHttpClient) : LocationApi = LocationApi(BuildConfig.BASE_URL_LOCATION_SERVICE,okHttpClient)
}