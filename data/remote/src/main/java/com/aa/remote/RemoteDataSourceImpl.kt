package com.aa.remote

import com.aa.remote.utils.NetworkException
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.resources.AllFoodAdviceResource
import com.aa.repository.resources.AllVideosResource
import com.aa.repository.resources.BabyGenderResource
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource
import com.aa.repository.resources.StoreBabyGenderResource
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val tinyStepsService: TinyStepsService,
) : RemoteDataSource {
    override suspend fun getFoodAdvices(): AllFoodAdviceResource {
        return tryToExecute { tinyStepsService.getFoodAdvices() }
    }

    override suspend fun loginRequest(loginResource: LoginResource): LoginResponseResource {
        return tryToExecute {
            tinyStepsService.loginRequest(
                loginResource
            )
        }
    }

    override suspend fun storeBabyGender(storeBabyGenderResource: StoreBabyGenderResource): BabyGenderResource {
        return tryToExecute {
            tinyStepsService.storeBabyGender(
                storeBabyGenderResource
            )
        }
    }

    override suspend fun deleteBabyGender(id: String) {
        return tryToExecute {
            tinyStepsService.deleteBabyGender(id)
        }
    }

    override suspend fun updateBabyGender(
        id: String,
        babyGender: String
    ) {
        return tryToExecute {
            tinyStepsService.updateBabyGender(babyId = id, babyGender = babyGender)
        }
    }

    override suspend fun getAllVideos(): AllVideosResource {
        return tryToExecute { tinyStepsService.getAllVideos() }
    }


    private suspend fun <T> tryToExecute(func: suspend () -> Response<T>): T {
        val response = func()
        if (response.isSuccessful) {
            return response.body() ?: throw NetworkException.NotFoundException
        }
        throw when (response.code()) {
            404 -> NetworkException.NotFoundException
            402 -> NetworkException.ApiKeyExpiredException
            401 -> NetworkException.UnAuthorizedException
            502 -> NetworkException.NoInternetException
            500 -> NetworkException.InternalServerError
            else -> IOException()
        }
    }
}