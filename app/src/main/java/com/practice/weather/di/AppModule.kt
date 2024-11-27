package com.practice.weather.di

import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.practice.weather.data.location.LocationTracker
import com.practice.weather.data.location.LocationTrackerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import android.app.Application

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFusedLocationProviderClient(application: Application) : FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(application)

    @Singleton
    @Provides
    fun provideLocationTracker(fusedLocationProviderClient: FusedLocationProviderClient, application: Application) : LocationTracker = LocationTrackerImpl(
        fusedLocationProviderClient,application
    )
}