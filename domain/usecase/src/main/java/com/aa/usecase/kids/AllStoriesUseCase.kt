package com.aa.usecase.kids

import com.aa.models.kids.AllStoriesEntity
import com.aa.repositories.KidsRepository
import javax.inject.Inject

class AllStoriesUseCase @Inject constructor(
    private val kidsRepository: KidsRepository
) {

    suspend operator fun invoke(id: Int?,title: String?):List<AllStoriesEntity>{
        return kidsRepository.getAllStories(id, title)
    }
}