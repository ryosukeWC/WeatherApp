package com.practice.weather.di

import com.example.api.NavigationApi
import com.example.impl.NavigationApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    abstract fun provideNavigationApi(impl: NavigationApiImpl) : NavigationApi
}