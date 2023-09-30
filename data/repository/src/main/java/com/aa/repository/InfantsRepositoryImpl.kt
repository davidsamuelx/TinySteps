package com.aa.repository

import com.aa.models.GuidanceInstructionEntity
import com.aa.models.InfantsBadHabitsEntity
import com.aa.models.InfantsExcersiceEntity
import com.aa.models.InfantsFoodEntity
import com.aa.models.InfantsProductsEntity
import com.aa.models.InfantsRelationEntity
import com.aa.models.InfantsSleepEntity
import com.aa.models.InfantsSpecialCaseEntity
import com.aa.repositories.InfantsRepository
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.mappers.toEntity
import com.aa.repository.utils.orZero
import java.util.Optional.empty
import javax.inject.Inject

class InfantsRepositoryImpl @Inject constructor(
        private val remoteDataSource: RemoteDataSource
):InfantsRepository{

    override suspend fun guidanceInstruction(): List<GuidanceInstructionEntity> {
        return remoteDataSource.getGuidanceInstruction().guidanceInstruction
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun selectGuidanceInstruction(id:String): GuidanceInstructionEntity {
        return remoteDataSource.selectGuidanceInstruction(id).guidanceInstruction?.toEntity()
            ?: GuidanceInstructionEntity(
                "",
                "",
                "",
                "",
                "",
                ""
            )
    }

    override suspend fun searchGuidanceInstruction(id: String): List<GuidanceInstructionEntity> {
        return remoteDataSource.searchGuidanceInstruction(id).guidanceInstruction
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsSleep(): List<InfantsSleepEntity> {
        return  remoteDataSource.getInfantsSleep().sleepBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun selectInfantsSleep(id: Int): InfantsSleepEntity {
        return remoteDataSource.selectInfantsSleep(id).SleepBaby?.toEntity()
            ?: InfantsSleepEntity(
                0,
                "",
                "",
                0,
                "",
                "",
                ""
            )
    }

    override suspend fun searchInfantsSleep(id: String): List<InfantsSleepEntity> {
        return remoteDataSource.searchInfantsSleep(id).sleepBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsExcersice(): List<InfantsExcersiceEntity> {
        return remoteDataSource.getInfantsExcersice().exercises
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun searchInfantsExcersice(videoPath: String): List<InfantsExcersiceEntity> {
        return remoteDataSource.searchInfantsExcersice(videoPath).searchResults
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun selectByIdExcersie(id: Int): InfantsExcersiceEntity {
        return remoteDataSource.selectByIdExcersice(id).exercise?.toEntity()
            ?: InfantsExcersiceEntity(
                "",
                "",
                0,
                "",
                ""
            )
    }

    override suspend fun infantsRelation(): List<InfantsRelationEntity> {
        return  remoteDataSource.getInfantsRelation().relations
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsRelationById(id: Int): InfantsRelationEntity {
        return remoteDataSource.getInfantsRelationById(id = id).relations?.toEntity()
            ?: InfantsRelationEntity(
                "",
                "",
                0,
                "",
                "",
                ""
            )
    }

    override suspend fun searchInfantsRelation(id: String): List<InfantsRelationEntity> {
        return remoteDataSource.searchInfantsRelation(id).relations
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsBadHabits(): List<InfantsBadHabitsEntity> {
        return remoteDataSource.getInfantsBadHabits().badhabits
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsBadHabitsById(id: Int): InfantsBadHabitsEntity {
        return remoteDataSource.getInfantsBadHabitsById(id= id).badhabit?.toEntity()
            ?: InfantsBadHabitsEntity(
            "",
            0,
            "",
            "",
                0,
                "",
                "",
                "",
                ""
        )
    }

    override suspend fun searchInfantsBadHabits(badHabit: String): List<InfantsBadHabitsEntity> {
        return remoteDataSource.searchInfantsBadHabits(badHabit).badhabits
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }


    override suspend fun infantsFood(): List<InfantsFoodEntity> {
        return remoteDataSource.getInfantsFood().foodBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsFoodById(id: Int): InfantsFoodEntity {
        return remoteDataSource.getInfantsFoodById(id=id).foodBaby?.toEntity()
            ?:InfantsFoodEntity(
                "",
                0,
                "",
                "",
                0,
                "",
                "",
                "",
                ""
            )
    }

    override suspend fun searchInfantsFood(foodSearch: String): List<InfantsFoodEntity> {
        return remoteDataSource.searchInfantsFood(foodSearch).foodBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }


    override suspend fun infantsSpecialCase(): List<InfantsSpecialCaseEntity> {
        return remoteDataSource.getInfantsSpecialCase().specialCases
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsSpecialCaseById(id: Int): InfantsSpecialCaseEntity {
    return  remoteDataSource.getInfantsSpecialCaseById(id=id).specialCase?.toEntity()
        ?:InfantsSpecialCaseEntity(
            "",
            0,
            "",
            "",
            0,
            "",
            "",
            "",
            ""
        )
    }

    override suspend fun searchInfantsSpecialCase(specialSearch: String): List<InfantsSpecialCaseEntity> {
        return remoteDataSource.searchInfantsSpecialCase(specialSearch).specialCases
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun getInfantsProducts(): List<InfantsProductsEntity> {
        return remoteDataSource.getInfantsProducts().sleepBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun selectInfantsProducts(id: String): InfantsProductsEntity {
        return remoteDataSource.selectInfantsProducts(id).product?.toEntity()
            ?: InfantsProductsEntity(
                "",
                0,
                "",
                "",
                0,
                "",
                ""
            )
    }

    override suspend fun searchInfantsProducts(products: String): List<InfantsProductsEntity> {
        return remoteDataSource.searchInfantsProducts(products).sleepBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

}