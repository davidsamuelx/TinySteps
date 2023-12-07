package com.aa.viewmodels.sleepposition

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.SleepPositionEntity

data class SleepPositionDetailsUiState(
    val sleepPosition: SleepPositionDetailItemUiState = SleepPositionDetailItemUiState(),
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
): BaseUiState

data class SleepPositionDetailItemUiState(
    val id: Int = 0,
    val nameOfPosition: String = "",
    val pathImg: String = "",
    val detailsOfPosition: String = "",
    val adviceId: Int = 0,
    val doctorName: String = "",
    val phoneDoctor: String = "",
    val profileDoctor: String = "",
    val doctorLocation: String = ""
)

fun SleepPositionEntity.toDetailUiState() = SleepPositionDetailItemUiState(
    id = id,
    nameOfPosition = nameOfPosition,
    pathImg = pathImg,
    detailsOfPosition = detailsOfPosition,
    adviceId = adviceId,
    doctorName = doctorName ,
    phoneDoctor = phoneDoctor,
    profileDoctor = profileDoctor ,
    doctorLocation = doctorLocation
)