package com.aa.repositories

import com.aa.models.infants.GuidanceInstructionEntity
import com.aa.models.infants.InfantsBadHabitsEntity
import com.aa.models.infants.InfantsExcersiceEntity
import com.aa.models.infants.InfantsFoodEntity
import com.aa.models.infants.InfantsProductsEntity
import com.aa.models.infants.InfantsRelationEntity
import com.aa.models.infants.InfantsSleepEntity
import com.aa.models.infants.InfantsSpecialCaseEntity
import kotlinx.coroutines.flow.Flow

interface InfantsRepository {

    suspend fun guidanceInstruction():List<GuidanceInstructionEntity>

    suspend fun selectGuidanceInstruction(id:String): GuidanceInstructionEntity

    suspend fun searchGuidanceInstruction(id: String):List<GuidanceInstructionEntity>

    suspend fun infantsSleep():List<InfantsSleepEntity>

    suspend fun selectInfantsSleep(id: Int): InfantsSleepEntity

    suspend fun searchInfantsSleep(id:String):List<InfantsSleepEntity>

    suspend fun infantsExcersice():List<InfantsExcersiceEntity>

    suspend fun searchInfantsExcersice(videoPath:String):List<InfantsExcersiceEntity>

    suspend fun selectByIdExcersie(id: Int): InfantsExcersiceEntity

    suspend fun infantsRelation():List<InfantsRelationEntity>

    suspend fun infantsRelationById(id: Int): InfantsRelationEntity

    suspend fun searchInfantsRelation(id:String):List<InfantsRelationEntity>

    suspend fun infantsBadHabits():List<InfantsBadHabitsEntity>

    suspend fun infantsBadHabitsById(id:Int): InfantsBadHabitsEntity

    suspend fun searchInfantsBadHabits(badHabit:String):List<InfantsBadHabitsEntity>

    suspend fun infantsFood():List<InfantsFoodEntity>

    suspend fun infantsFoodById(id:Int): InfantsFoodEntity

    suspend fun searchInfantsFood(foodSearch:String):List<InfantsFoodEntity>

    suspend fun infantsSpecialCase():List<InfantsSpecialCaseEntity>

    suspend fun infantsSpecialCaseById(id:Int): InfantsSpecialCaseEntity

    suspend fun searchInfantsSpecialCase(specialSearch:String):List<InfantsSpecialCaseEntity>

    suspend fun getInfantsProducts():List<InfantsProductsEntity>

    suspend fun selectInfantsProducts(id: String): InfantsProductsEntity

    suspend fun searchInfantsProducts(products:String):List<InfantsProductsEntity>


}