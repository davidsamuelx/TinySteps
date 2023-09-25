package com.aa.tinysteps.di

import android.content.Context
import androidx.room.Room
import com.aa.local.DatabaseTest
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseTestModule {


    fun provideTestTinyStepsDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            DatabaseTest::class.java,
            "databaseTest"
        ).build()

}