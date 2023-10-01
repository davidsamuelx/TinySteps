package com.aa.remote

import com.aa.remote.utils.NetworkException
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.resources.AllBadHabitsResource
import com.aa.repository.resources.AllENSupportMessagesResource
import com.aa.repository.resources.AllFoodAdviceResource
import com.aa.repository.resources.AllSpecialCaseResource
import com.aa.repository.resources.BabyGenderResource
import com.aa.repository.resources.BadHabitByIdResource
import com.aa.repository.resources.ENImageResource
import com.aa.repository.resources.FoodByIdResource
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource
import com.aa.repository.resources.NoteResource
import com.aa.repository.resources.NoteResponceResource
import com.aa.repository.resources.PregnancyResource
import com.aa.repository.resources.PregnancyResponseResource
import com.aa.repository.resources.PregnancyStoreResource
import com.aa.repository.resources.SearchBadHabitResource
import com.aa.repository.resources.SearchFoodResource
import com.aa.repository.resources.SearchedENSupportMessageResource
import com.aa.repository.resources.SelectedSupportMessageTypeResource
import com.aa.repository.resources.StoreBabyGenderResource
import com.aa.repository.resources.SupportMessageEnglishResource
import com.aa.repository.resources.TodayENSupportMessageResource
import com.aa.repository.resources.UpdatePregnancyResource
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

    override suspend fun addENSupportMessage(
        selectedSupportMessageTypeResource: SelectedSupportMessageTypeResource
    ): SupportMessageEnglishResource {
        return tryToExecute {
            tinyStepsService.addSupportMessageEnglish(selectedSupportMessageTypeResource)
        }
    }

    override suspend fun getAllENSupportMessages(): AllENSupportMessagesResource {
        return tryToExecute { tinyStepsService.getAllENSupportMessage() }
    }

    override suspend fun getENSupportMessageById(id: Int): SearchedENSupportMessageResource {
        return tryToExecute { tinyStepsService.getENSupportMessageById(id) }
    }

    override suspend fun deleteENSupportMessage(id: Int) {
        return tryToExecute { tinyStepsService.deleteENSupportMessage(id) }
    }

    override suspend fun updateENSupportMessage(id: Int, messageType: String) {
        return tryToExecute { tinyStepsService.updateENSupportMessage(
            messageId = id, selectWhenSendSupportMessage = messageType
        ) }
    }

    override suspend fun getImage(): ENImageResource {
        return tryToExecute { tinyStepsService.getENImage() }
    }

    override suspend fun getTodaySupportMessage(): TodayENSupportMessageResource {
        return tryToExecute { tinyStepsService.getTodaySupportMessage() }
    }

    override suspend fun addNote(noteResource: NoteResource): NoteResponceResource {
        return tryToExecute { tinyStepsService.addNote(noteResource) }
    }

    override suspend fun getPregnancyData(): PregnancyResource {
        return tryToExecute { tinyStepsService.getPregnancyData() }
    }

    override suspend fun addPregnancy(pregnancyStoreResource: PregnancyStoreResource): PregnancyResponseResource {
        return tryToExecute { tinyStepsService.addPregnancy(pregnancyStoreResource) }
    }

    override suspend fun updatePregnancy(id: Int, startTime: String): UpdatePregnancyResource {
        return tryToExecute { tinyStepsService.updatePregnancy(
            userId = id,
            startDate = startTime
        ) }
    }

    override suspend fun deletePregnancy(id: Int) {
        return tryToExecute { tinyStepsService.deletePregnancy(id) }
    }

    override suspend fun getAllBadHabit(): AllBadHabitsResource {
        return tryToExecute { tinyStepsService.getBadHabit() }
    }

    override suspend fun getAllSpecialCases(): AllSpecialCaseResource {
        return tryToExecute { tinyStepsService.getSpecialCases() }
    }

    override suspend fun getFoodById(id: Int): FoodByIdResource {
        return tryToExecute { tinyStepsService.getFoodById(id) }
    }

    override suspend fun searchFood(foodSearch: String): SearchFoodResource {
        return tryToExecute { tinyStepsService.searchFood(foodSearch) }
    }

    override suspend fun getAllBadHabitById(id: Int): BadHabitByIdResource {
        return tryToExecute { tinyStepsService.getBadHabitsById(id) }
    }

    override suspend fun searchBadHabit(badHabit: String): SearchBadHabitResource {
        return tryToExecute { tinyStepsService.searchBadHabits(badHabit) }
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