package com.aa.repository.datasources

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
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource

interface RemoteDataSource {

    suspend fun getFoodAdvices(): AllFoodAdviceResource

    //phase 02 infants and Toddler
    suspend fun getGuidanceInstruction(): AllGuidanceInstructionResource
    suspend fun selectGuidanceInstruction(id:String):AllGuidanceInstructionSelectResource
    suspend fun searchGuidanceInstruction(id:String): AllGuidanceInstructionResource

    suspend fun getInfantsSleep(): InfantsSleepResource
    suspend fun selectInfantsSleep(id: Int):AllInfantsSleepSelectResource
    suspend fun searchInfantsSleep(id:String): InfantsSleepResource

    suspend fun getInfantsExcersice(): AllInfantsExcersiceResource
    suspend fun searchInfantsExcersice(videoPath:String):AllInfantsExcersiceSearchResource
    suspend fun selectByIdExcersice(id:Int):AllInfantsExcersiceSelectByIdResource

    suspend fun getInfantsRelation(): AllInfantsRelationResource
    suspend fun getInfantsRelationById(id:Int):AllInfantsRelationByIdResource
    suspend fun searchInfantsRelation(searchId:String):AllInfantsRelationResource

    suspend fun getInfantsBadHabits(): AllInfantsBadHabitsResource
    suspend fun getInfantsBadHabitsById(id:Int): AllInfantsBadHabitsByIdResource
    suspend fun searchInfantsBadHabits(badHabit:String): AllInfantsBadHabitsResource

    suspend fun getInfantsFood(): AllInfantsFoodResource
    suspend fun getInfantsFoodById(id:Int): AllInfantsFoodByIdResource
    suspend fun searchInfantsFood(foodSearch:String): AllInfantsFoodResource

    suspend fun getInfantsSpecialCase(): AllInfantsSpecialCaseResource
    suspend fun getInfantsSpecialCaseById(id: Int): AllInfantsSpecialCaseByIdResource
    suspend fun searchInfantsSpecialCase(specialSearch:String): AllInfantsSpecialCaseResource

    suspend fun getInfantsProducts():AllInfantsProductsResource
    suspend fun selectInfantsProducts(id: String):AllInfantsProductsSelectResource
    suspend fun searchInfantsProducts(product:String):AllInfantsProductsResource

    suspend fun loginRequest(
        loginResource: LoginResource,
    ): LoginResponseResource
}