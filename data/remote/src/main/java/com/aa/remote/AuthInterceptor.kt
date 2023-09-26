package com.aa.remote

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .cacheControl(cacheControl)
            .header("Authorization", "bearer $TOKEN")
            .build()
        return chain.proceed(request)
    }


    private val cacheControl = CacheControl.Builder()
        .maxAge(1, TimeUnit.HOURS)
        .build()


    private companion object {
        const val TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3Rpbnktc3RlcHMuaGVscC9hcGkvYXV0aC91c2VyL2xvZ2luIiwiaWF0IjoxNjk1NzQzMzYxLCJleHAiOjE2OTU3NDY5NjEsIm5iZiI6MTY5NTc0MzM2MSwianRpIjoiMDdkN2xuM2dtbENNZnVaZyIsInN1YiI6IjciLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.qXqrbqkgfksLZ-7I_qPqGkK3NzZ_yV0c9MyzeO1TZPg"
    }

}