package com.aa.tinysteps.di

import android.content.Context
import android.content.SharedPreferences
import com.aa.local.SharedPrefImpl
import com.aa.repository.datasources.SharedPreferenceDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {

    @Provides
    @Singleton
    fun provideTinyStepsSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("Tiny-Steps-SharedPref", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideSharedPreferencesDataSource(sharedPrefImpl: SharedPrefImpl): SharedPreferenceDataSource{
        return sharedPrefImpl
    }
}

