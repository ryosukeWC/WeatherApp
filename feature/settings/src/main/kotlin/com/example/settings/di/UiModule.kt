package com.example.settings.di

import android.content.Context
import com.example.api.NavigationApi
import com.example.settings.PopMenuInstanceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(FragmentComponent::class)
object UiModule {

    @Provides
    fun providePopMenuInstanceFactory(
        @ApplicationContext context: Context,
        navApi: NavigationApi
    ): PopMenuInstanceFactory = PopMenuInstanceFactory(context, navApi)
}