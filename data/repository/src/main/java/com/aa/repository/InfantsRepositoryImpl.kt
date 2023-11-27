package com.aa.repository


import com.aa.models.infants.GuidanceInstructionEntity
import com.aa.models.infants.InfantsBadHabitsEntity
import com.aa.models.infants.InfantsExerciseEntity
import com.aa.models.infants.InfantsFoodEntity
import com.aa.models.infants.InfantsProductsEntity
import com.aa.models.infants.InfantsRelationEntity
import com.aa.models.infants.InfantsSleepEntity
import com.aa.models.infants.InfantsSpecialCaseEntity
import com.aa.repositories.InfantsRepository
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.mappers.toEntity
import javax.inject.Inject

class InfantsRepositoryImpl @Inject constructor(
        private val remoteDataSource: RemoteDataSource,
):InfantsRepository{

    override suspend fun guidanceInstruction(): List<GuidanceInstructionEntity> {
        return remoteDataSource.getGuidanceInstruction().guidanceInstruction
            ?.map { it.toEntity() }?: emptyList()
    }

    override suspend fun selectGuidanceInstruction(id: Int): GuidanceInstructionEntity {
        return remoteDataSource.selectGuidanceInstruction(id).guidanceInstruction.toEntity()
    }

    override suspend fun searchGuidanceInstruction(id: String): List<GuidanceInstructionEntity> {
        TODO("Not yet implemented")
    }


    override suspend fun infantsSleep(): List<InfantsSleepEntity> {
        return  remoteDataSource.getInfantsSleep().sleepBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun selectInfantsSleep(id: Int): InfantsSleepEntity {
    return remoteDataSource.selectInfantsSleep(id).SleepBaby.toEntity()
    }


    override suspend fun searchInfantsSleep(id: String): List<InfantsSleepEntity> {
        return remoteDataSource.searchInfantsSleep(id).sleepBabies
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun infantsExcersice(): List<InfantsExerciseEntity> {
        return remoteDataSource.getInfantsExercise().exercises
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun searchInfantsExcersice(videoPath: String): List<InfantsExerciseEntity> {
        return remoteDataSource.searchInfantsExercise(videoPath).infantExerciseSearchResults
            ?.mapNotNull { it?.toEntity() }?: emptyList()
    }

    override suspend fun selectByIdExcersie(id: Int): InfantsExerciseEntity {
        return remoteDataSource.selectByIdExercise(id).exercise.toEntity()
    }


    override suspend fun infantsRelation(): List<InfantsRelationEntity> {
        return  remoteDataSource.getInfantsRelation().relations
            ?.map { it.toEntity() }?: emptyList()
    }

    override suspend fun infantsRelationById(id: Int): InfantsRelationEntity {
        return remoteDataSource.getInfantsRelationById(id).relations.toEntity()
    }


    override suspend fun searchInfantsRelation(id: String): List<InfantsRelationEntity> {
        return remoteDataSource.searchInfantsRelation(id).relations
            ?.map { it.toEntity() }?: emptyList()
    }

    override suspend fun infantsBadHabits(): List<InfantsBadHabitsEntity> {
        return remoteDataSource.getInfantsBadHabits().badhabits
            ?.map { it.toEntity() }?: emptyList()
    }

    override suspend fun infantsBadHabitsById(id: Int): InfantsBadHabitsEntity{
        return remoteDataSource.getInfantsBadHabitsById(id).badhabit.toEntity()
    }


    override suspend fun searchInfantsBadHabits(badHabit: String): List<InfantsBadHabitsEntity> {
        return remoteDataSource.searchInfantsBadHabits(badHabit).badhabits
            ?.map { it.toEntity() }?: emptyList()
    }


    override suspend fun infantsFood(): List<InfantsFoodEntity> {
        return remoteDataSource.getInfantsFood().foodBabies
            ?.map { it.toEntity() }?: emptyList()
    }

    override suspend fun infantsFoodById(id: Int): InfantsFoodEntity {
        return remoteDataSource.getInfantsFoodById(id).foodBaby.toEntity()
    }


    override suspend fun searchInfantsFood(foodSearch: String): List<InfantsFoodEntity> {
        return remoteDataSource.searchInfantsFood(foodSearch).foodBabies
            ?.map { it.toEntity() }?: emptyList()
    }


    override suspend fun infantsSpecialCase(): List<InfantsSpecialCaseEntity> {
        return remoteDataSource.getInfantsSpecialCase().specialCases
            ?.map { it.toEntity() }?: emptyList()
    }

    override suspend fun infantsSpecialCaseById(id: Int): InfantsSpecialCaseEntity {
            return remoteDataSource.getInfantsSpecialCaseById(id).specialCase.toEntity()
    }


    override suspend fun searchInfantsSpecialCase(specialSearch: String): List<InfantsSpecialCaseEntity> {
        return remoteDataSource.searchInfantsSpecialCase(specialSearch).specialCases
            ?.map { it.toEntity() }?: emptyList()
    }

    override suspend fun getInfantsProducts(): List<InfantsProductsEntity> {
        return remoteDataSource.getInfantsProducts().sleepBabies
            ?.map { it.toEntity() }?: emptyList()
    }

    override suspend fun selectInfantsProducts(id: String): InfantsProductsEntity{
        return remoteDataSource.selectInfantsProducts(id).products.toEntity()
    }


    override suspend fun searchInfantsProducts(products: String): List<InfantsProductsEntity> {
        return remoteDataSource.searchInfantsProducts(products).sleepBabies
            ?.map { it.toEntity() }?: emptyList()
    }




}