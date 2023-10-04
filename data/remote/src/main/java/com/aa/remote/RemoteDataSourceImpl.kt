package com.aa.remote

import com.aa.remote.utils.NetworkException
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.resources.AllBadHabitsResource
import com.aa.repository.resources.AllENSupportMessagesResource
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
import com.aa.repository.resources.Infants.AllInfantsProductsResource
import com.aa.repository.resources.Infants.AllInfantsProductsSelectResource
import com.aa.repository.resources.Infants.AllInfantsRelationByIdResource
import com.aa.repository.resources.Infants.AllInfantsRelationResource
import com.aa.repository.resources.Infants.AllInfantsSleepSelectResource
import com.aa.repository.resources.Infants.AllInfantsSpecialCaseByIdResource
import com.aa.repository.resources.Infants.AllInfantsSpecialCaseResource
import com.aa.repository.resources.Infants.InfantsSleepResource
import com.aa.repository.resources.AllMusicResource
import com.aa.repository.resources.AllVideosResource
import com.aa.repository.resources.AllSpecialCaseResource
import com.aa.repository.resources.BabyGenderResource
import com.aa.repository.resources.BadHabitByIdResource
import com.aa.repository.resources.ENImageResource
import com.aa.repository.resources.FoodByIdResource
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource
import com.aa.repository.resources.MusicResource
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
import com.aa.repository.resources.VideoResource
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

    override suspend fun searchInfantsRelation(searchId:String): AllInfantsRelationResource {
        return tryToExecute { tinyStepsService.searchInfantsRelation(searchId) }
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

    override suspend fun getInfantsProducts(): AllInfantsProductsResource {
        return tryToExecute { tinyStepsService.getInfantsProducts() }
    }

    override suspend fun selectInfantsProducts(id: String): AllInfantsProductsSelectResource {
        return tryToExecute { tinyStepsService.selectInfantsProducts(id) }
    }

    override suspend fun searchInfantsProducts(product: String): AllInfantsProductsResource {
        return tryToExecute { tinyStepsService.searchInfantsProducts(product) }
    }

    //endregion


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

    override suspend fun getAllVideos(): AllVideosResource {
        return tryToExecute { tinyStepsService.getAllVideos() }
    }

    override suspend fun getVideoById(id: Int): VideoResource {
        return tryToExecute { tinyStepsService.getVideoById(id) }
    }

    override suspend fun getVideosByName(name: String): AllVideosResource {
        return tryToExecute { tinyStepsService.searchVideoByName(name) }
    }

    override suspend fun getAllMusics(): AllMusicResource {
        return tryToExecute { tinyStepsService.getAllMusics() }
    }

    override suspend fun getMusicById(id: Int): MusicResource {
        return tryToExecute { tinyStepsService.getMusicById(id) }
    }

    override suspend fun getMusicByType(musicType: String): AllMusicResource {
        return tryToExecute { tinyStepsService.searchMusicByType(musicType) }
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