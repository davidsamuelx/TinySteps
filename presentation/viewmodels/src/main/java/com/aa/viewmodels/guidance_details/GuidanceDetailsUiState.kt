package com.aa.viewmodels.guidance_details

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.GuidanceInstructionEntity

data class GuidanceDetailsUiState(
    val guidance: GuidanceDetailsItemUiState = GuidanceDetailsItemUiState(),
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
): BaseUiState

data class GuidanceDetailsItemUiState(
    val id:Int = 0 ,
    val guidanceDetails: String = "" ,
    val doctorName: String = "" ,
    val guidanceImg: String = "" ,
    val guidanceTitle: String = "",
    val phoneDoctor: String = "",
    val doctorLocation: String = "",
)

fun GuidanceInstructionEntity.toDetailsUiState() = GuidanceDetailsItemUiState(
    id = id ?: 0,
    guidanceTitle = titleEN ?: "",
    guidanceDetails = detailsEn ?: "",
    guidanceImg = image ?: "",
    doctorName = doctorName ?: "",
    phoneDoctor = phoneDoctor ?: "",
    doctorLocation = doctorLocation ?: ""
)