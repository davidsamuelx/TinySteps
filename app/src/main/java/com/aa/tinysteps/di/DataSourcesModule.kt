package com.aa.tinysteps.di

import com.aa.remote.RemoteDataSourceImpl
import com.aa.repositories.AuthenticationRepository
import com.aa.repositories.InfantsRepository
import com.aa.repositories.KidsRepository
import com.aa.repositories.OpenAIRepository
import com.aa.repositories.PregnancyRepository
import com.aa.repository.AuthenticationRepositoryImpl
import com.aa.repository.InfantsRepositoryImpl
import com.aa.repository.KidsRepositoryImpl
import com.aa.repository.OpenAIRepositoryImpl
import com.aa.repository.PregnancyRepositoryImpl
import com.aa.repository.datasources.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourcesModule {

    @Binds
    @Singleton
    abstract fun bindRemoteDataSourceRepository(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @Singleton
    abstract fun bindPregnancyRepo(pregnancyRepositoryImpl: PregnancyRepositoryImpl): PregnancyRepository

    @Binds
    @Singleton
    abstract  fun  bindInfantsRepo(infantsRepositoryImpl: InfantsRepositoryImpl):InfantsRepository


    @Binds
    @Singleton
    abstract fun bindAuthenticationRepo(authenticationRepositoryImpl: AuthenticationRepositoryImpl): AuthenticationRepository

    @Binds
    @Singleton
    abstract fun bindKidREpo(kidsRepositoryImpl: KidsRepositoryImpl): KidsRepository

    @Binds
    @Singleton
    abstract fun bindOpenAIRepo(openAIRepositoryImpl: OpenAIRepositoryImpl): OpenAIRepository

}