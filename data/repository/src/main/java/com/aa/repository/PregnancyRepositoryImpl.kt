package com.aa.repository

import com.aa.models.AddNoteEntity
import com.aa.models.AllFoodAdviceEntity
import com.aa.models.AllSupportMessagesEntity
import com.aa.models.BabyGenderEntity
import com.aa.models.ImageEntity
import com.aa.models.NoteEntity
import com.aa.models.PregnancyEntity
import com.aa.models.PregnancyResponseEntity
import com.aa.models.PregnancyStoreEntity
import com.aa.models.SelectedSupportMessageEntity
import com.aa.models.StoreBabyGenderEntity
import com.aa.models.SupportMessageEntity
import com.aa.models.TodayENSupportMessageEntity
import com.aa.models.UpdatePregnancyEntity
import com.aa.repositories.PregnancyRepository
import com.aa.repository.datasources.RemoteDataSource
import com.aa.repository.mappers.toEntity
import com.aa.repository.mappers.toResource
import javax.inject.Inject

class PregnancyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
): PregnancyRepository {
    override suspend fun allFoodAdvice(): List<AllFoodAdviceEntity> {
        return remoteDataSource.getFoodAdvices().foodBabies
            ?.mapNotNull { it?.toEntity() } ?: emptyList()
    }

    override suspend fun storeBabyGender(storeBabyGenderEntity: StoreBabyGenderEntity): BabyGenderEntity {
        return remoteDataSource.storeBabyGender(storeBabyGenderEntity.toResource()).toEntity()
    }

    override suspend fun deleteBabyGender(id: String) {
        return remoteDataSource.deleteBabyGender(id)
    }

    override suspend fun updateBabyGender( babyId: String, babyGender: String) {
        return remoteDataSource.updateBabyGender(
            id = babyId,
            babyGender = babyGender
        )
    }

    override suspend fun addENSupportMessage(selectedSupportMessageEntity: SelectedSupportMessageEntity): SupportMessageEntity {
        return remoteDataSource.addENSupportMessage(selectedSupportMessageEntity.toResource()).toEntity()
    }

    override suspend fun allENSupportMessage(): List<AllSupportMessagesEntity> {
        return remoteDataSource.getAllENSupportMessages().records
            ?.mapNotNull { it?.toEntity() } ?: emptyList()
    }

    override suspend fun getENSupportMessageById(id: Int): SupportMessageEntity {
        return remoteDataSource.getENSupportMessageById(id).toEntity()
    }

    override suspend fun deleteEnSupportMessage(id: Int) {
        return remoteDataSource.deleteENSupportMessage(id)
    }

    override suspend fun updateEnSupportMessage(messageId: Int, messageType: String) {
        return remoteDataSource.updateENSupportMessage(
            id = messageId,
            messageType = messageType
        )
    }

    override suspend fun getImage(): ImageEntity {
        return remoteDataSource.getImage().toEntity()
    }

    override suspend fun getTodaySupportMessage(): TodayENSupportMessageEntity {
        return remoteDataSource.getTodaySupportMessage().toEntity()
    }

    override suspend fun addNote(addNoteEntity: AddNoteEntity): NoteEntity {
        return remoteDataSource.addNote(addNoteEntity.toResource()).toEntity()
    }

    override suspend fun getPregnancyData(): List<PregnancyEntity> {
        return remoteDataSource.getPregnancyData().records
            ?.mapNotNull { it?.data?.toEntity() } ?: emptyList()

    }

    override suspend fun addPregnancy(pregnancyStoreEntity: PregnancyStoreEntity): PregnancyResponseEntity {
        return remoteDataSource.addPregnancy(pregnancyStoreEntity.toResource()).toEntity()
    }

    override suspend fun updatePregnancy(id: Int, startTime: String): UpdatePregnancyEntity {
        return remoteDataSource.updatePregnancy(
            id = id,
            startTime = startTime
        ).toEntity()
    }

    override suspend fun deletePregnancy(id: Int) {
        return remoteDataSource.deletePregnancy(id)
    }

    override suspend fun getAllBadHabit() {
        return remoteDataSource.getAllBadHabit()
    }

    override suspend fun getAllSpecialCases() {
        return remoteDataSource.getAllSpecialCases()
    }

}