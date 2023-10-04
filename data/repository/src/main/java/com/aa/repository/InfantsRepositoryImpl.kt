package com.aa.repository

import com.aa.models.infants.GuidanceInstructionEntity
import com.aa.models.infants.InfantsBadHabitsEntity
import com.aa.models.infants.InfantsExcersiceEntity
import com.aa.models.infants.InfantsFoodEntity
import com.aa.models.infants.InfantsProductsEntity
import com.aa.models.infants.InfantsRelationEntity
import com.aa.models.infants.InfantsSleepEntity
import com.aa.models.infants.InfantsSpecialCaseEntity
import com.aa.repositories.InfantsRepository
import com.aa.repository.datasources.LocalDataSource
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.mappers.toDTO
import com.aa.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

class InfantsRepositoryImpl @Inject constructor(
        private val remoteDataSource: RemoteDataSource,
):InfantsRepository{

    override suspend fun guidanceInstruction(): List<GuidanceInstructionEntity> {
        return remoteDataSource.getGuidanceInstruction().guidanceInstruction
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun selectGuidanceInstruction(id: String): GuidanceInstructionEntity? {
        return remoteDataSource.selectGuidanceInstruction(id).guidanceInstruction?.toEntity()
    }


    override suspend fun searchGuidanceInstruction(id: String): List<GuidanceInstructionEntity> {
        return remoteDataSource.searchGuidanceInstruction(id).guidanceInstruction
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsSleep(): List<InfantsSleepEntity> {
        return  remoteDataSource.getInfantsSleep().sleepBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun selectInfantsSleep(id: Int): InfantsSleepEntity? {
    return remoteDataSource.selectInfantsSleep(id).SleepBaby?.toEntity()
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

    override suspend fun selectByIdExcersie(id: Int): InfantsExcersiceEntity? {
        return remoteDataSource.selectByIdExcersice(id).exercise?.toEntity()
    }


    override suspend fun infantsRelation(): List<InfantsRelationEntity> {
        return  remoteDataSource.getInfantsRelation().relations
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsRelationById(id: Int): InfantsRelationEntity? {
        return remoteDataSource.getInfantsRelationById(id).relations?.toEntity()
    }


    override suspend fun searchInfantsRelation(id: String): List<InfantsRelationEntity> {
        return remoteDataSource.searchInfantsRelation(id).relations
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsBadHabits(): List<InfantsBadHabitsEntity> {
        return remoteDataSource.getInfantsBadHabits().badhabits
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsBadHabitsById(id: Int): InfantsBadHabitsEntity? {
        return remoteDataSource.getInfantsBadHabitsById(id).badhabit?.toEntity()
    }


    override suspend fun searchInfantsBadHabits(badHabit: String): List<InfantsBadHabitsEntity> {
        return remoteDataSource.searchInfantsBadHabits(badHabit).badhabits
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }


    override suspend fun infantsFood(): List<InfantsFoodEntity> {
        return remoteDataSource.getInfantsFood().foodBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsFoodById(id: Int): InfantsFoodEntity? {
        return remoteDataSource.getInfantsFoodById(id).foodBaby?.toEntity()
    }


    override suspend fun searchInfantsFood(foodSearch: String): List<InfantsFoodEntity> {
        return remoteDataSource.searchInfantsFood(foodSearch).foodBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }


    override suspend fun infantsSpecialCase(): List<InfantsSpecialCaseEntity> {
        return remoteDataSource.getInfantsSpecialCase().specialCases
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsSpecialCaseById(id: Int): InfantsSpecialCaseEntity? {
            return remoteDataSource.getInfantsSpecialCaseById(id).specialCase?.toEntity()
    }


    override suspend fun searchInfantsSpecialCase(specialSearch: String): List<InfantsSpecialCaseEntity> {
        return remoteDataSource.searchInfantsSpecialCase(specialSearch).specialCases
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun getInfantsProducts(): List<InfantsProductsEntity> {
        return remoteDataSource.getInfantsProducts().sleepBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun selectInfantsProducts(id: String): InfantsProductsEntity? {
        return remoteDataSource.selectInfantsProducts(id).product?.toEntity()
    }


    override suspend fun searchInfantsProducts(products: String): List<InfantsProductsEntity> {
        return remoteDataSource.searchInfantsProducts(products).sleepBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }




}