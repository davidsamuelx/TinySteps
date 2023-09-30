package com.aa.remote

import com.aa.remote.utils.NetworkException
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.resources.AllFoodAdviceResource
import com.aa.repository.resources.Infants.AllGuidanceInstructionResource
import com.aa.repository.resources.Infants.AllGuidanceInstructionSelectResource
import com.aa.repository.resources.Infants.AllInfantsBadHabitsByIdResource
import com.aa.repository.resources.Infants.AllInfantsBadHabitsResource
import com.aa.repository.resources.Infants.AllInfantsExcersiceResource
import com.aa.repository.resources.Infants.AllInfantsExcersiceSearchResource
import com.aa.repository.resources.Infants.AllInfantsExcersiceSelectByIdResource
import com.aa.repository.resources.Infants.AllInfantsFoodByIdResource
import com.aa.repository.resources.Infants.AllInfantsFoodResource
import com.aa.repository.resources.Infants.AllInfantsRelationByIdResource
import com.aa.repository.resources.Infants.AllInfantsRelationResource
import com.aa.repository.resources.Infants.AllInfantsSleepSelectResource
import com.aa.repository.resources.Infants.AllInfantsSpecialCaseByIdResource
import com.aa.repository.resources.Infants.AllInfantsSpecialCaseResource
import com.aa.repository.resources.Infants.InfantsSleepResource
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val tinyStepsService: TinyStepsService,
) : RemoteDataSource {
    override suspend fun getFoodAdvices(): AllFoodAdviceResource {
        return tryToExecute { tinyStepsService.getFoodAdvices() }
    }

    //phase 02 infants and Toddler

    override suspend fun getGuidanceInstruction(): AllGuidanceInstructionResource {
        return  tryToExecute { tinyStepsService.getGuidanceAdvice() }
    }

    override suspend fun selectGuidanceInstruction(id:String): AllGuidanceInstructionSelectResource {
        return tryToExecute { tinyStepsService.selectGuidanceAdvice(id) }
    }

    override suspend fun searchGuidanceInstruction(id: String): AllGuidanceInstructionResource {
        return tryToExecute { tinyStepsService.searchGuidanceAdvice(id) }
    }

    override suspend fun getInfantsSleep(): InfantsSleepResource {
        return  tryToExecute { tinyStepsService.getInfantsSleep() }
    }

    override suspend fun selectInfantsSleep(id: Int): AllInfantsSleepSelectResource {
        return tryToExecute { tinyStepsService.selectInfantsSleep(id) }
    }

    override suspend fun searchInfantsSleep(id: String): InfantsSleepResource {
        return tryToExecute { tinyStepsService.searchInfantsSleep(id) }
    }


    override suspend fun getInfantsExcersice(): AllInfantsExcersiceResource {
    return  tryToExecute { tinyStepsService.getInfantsExcersice() }
    }

    override suspend fun searchInfantsExcersice(videoPath: String): AllInfantsExcersiceSearchResource {
        return tryToExecute { tinyStepsService.searchInfantsExcersice(videoPath) }
    }

    override suspend fun selectByIdExcersice(id: Int): AllInfantsExcersiceSelectByIdResource {
        return tryToExecute { tinyStepsService.selectByIdInfantsExcersie(id) }
    }

    override suspend fun getInfantsRelation(): AllInfantsRelationResource {
        return  tryToExecute { tinyStepsService.getInfantsRelation() }
    }

    override suspend fun getInfantsRelationById(id: Int): AllInfantsRelationByIdResource {
        return tryToExecute { tinyStepsService.getInfantsRelationById(id = id) }
    }

    override suspend fun searchInfantsRelation(id: String): AllInfantsRelationResource {
        return tryToExecute { tinyStepsService.searchInfantsRelation(id) }
    }

    override suspend fun getInfantsBadHabits(): AllInfantsBadHabitsResource {
        return tryToExecute { tinyStepsService.getInfantsBadHabits() }
    }

    override suspend fun getInfantsBadHabitsById(id:Int): AllInfantsBadHabitsByIdResource {
    return tryToExecute { tinyStepsService.getInfantsBadHabitsById(id = id) }
    }

    override suspend fun searchInfantsBadHabits(badHabit: String): AllInfantsBadHabitsResource {
        return tryToExecute { tinyStepsService.searchInfantsBadHabits(badHabit) }
    }


    override suspend fun getInfantsFood(): AllInfantsFoodResource {
        return  tryToExecute { tinyStepsService.getInfantsFood() }
    }

    override suspend fun getInfantsFoodById(id: Int): AllInfantsFoodByIdResource {
        return  tryToExecute { tinyStepsService.getInfantsFoodById(id =id) }
    }

    override suspend fun searchInfantsFood(foodSearch: String): AllInfantsFoodResource {
        return tryToExecute { tinyStepsService.searchInfantsFood(foodSearch) }
    }


    override suspend fun getInfantsSpecialCase(): AllInfantsSpecialCaseResource {
        return tryToExecute { tinyStepsService.getInfantsSpecialCase() }
    }

    override suspend fun getInfantsSpecialCaseById(id: Int): AllInfantsSpecialCaseByIdResource {
        return tryToExecute { tinyStepsService.getInfantsSpecialCaseById(id=id) }
    }

    override suspend fun searchInfantsSpecialCase(specialSearch: String): AllInfantsSpecialCaseResource {
        return tryToExecute { tinyStepsService.searchInfantsSpecialCase(specialSearch) }
    }


    override suspend fun loginRequest(loginResource: LoginResource): LoginResponseResource {
        return tryToExecute {
            tinyStepsService.loginRequest(
                loginResource
            )
        }
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