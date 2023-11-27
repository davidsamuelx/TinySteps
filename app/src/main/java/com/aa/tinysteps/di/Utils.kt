package com.aa.tinysteps.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TinyStepsOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OpenAIOkHttpClient