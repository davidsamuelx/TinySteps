package com.aa.tinysteps.di

import com.aa.remote.AIInterceptor
import com.aa.remote.AuthInterceptor
import com.aa.remote.OpenAIService
import com.aa.remote.TinyStepsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    private const val TINY_STEPS_BASE_URL = "https://tiny-steps.help/api/"
    private const val OPENAI_BASE_URL = "https://api.openai.com/v1/"

    @Provides
    fun provideTinyStepsService(
        @TinyStepsOkHttpClient okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): TinyStepsService {
        return provideRetrofit(TINY_STEPS_BASE_URL, okHttpClient, gsonConverterFactory)
            .create(TinyStepsService::class.java)
    }

    @Provides
    fun provideOpenAIService(
        @OpenAIOkHttpClient okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): OpenAIService {
        return provideRetrofit(OPENAI_BASE_URL, okHttpClient, gsonConverterFactory)
            .create(OpenAIService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        baseUrl: String,
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @TinyStepsOkHttpClient
    @Provides
    @Singleton
    fun provideTinyStepsOkHttpClient(
        authInterceptor: AuthInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @OpenAIOkHttpClient
    @Provides
    @Singleton
    fun provideOpenAIOkHttpClient(
        openAIInterceptor: AIInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(openAIInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS) // Set connection timeout
            .readTimeout(60, TimeUnit.SECONDS) // Set read timeout
            .writeTimeout(60, TimeUnit.SECONDS) // Set write timeout
            .build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}
