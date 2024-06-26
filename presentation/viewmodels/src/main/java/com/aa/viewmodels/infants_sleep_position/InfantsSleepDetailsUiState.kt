package com.aa.viewmodels.infants_sleep_position

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.InfantsSleepEntity

data class InfantsSleepDetailsUiState(
    val infantsSleep: InfantsSleepDetailItemUiState = InfantsSleepDetailItemUiState(),
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
): BaseUiState

data class InfantsSleepDetailItemUiState(
    val id: Int? = 0,
    val recommendedSleepHours: String? = "",
    val pathImg: String? = "",
    val details: String? = "",
    val adviceId: Int? = 0,
    val doctorName: String? = "",
    val phoneDoctor: String? = "",
    val profileDoctor: String? = "",
    val doctorLocation: String? = "",
    val age: String? = ""
)

fun InfantsSleepEntity.toDetailUiState() = InfantsSleepDetailItemUiState(
    id = id,
    recommendedSleepHours = recommendedSleepHours,
    details = detailsEn,
    pathImg=pathImg,
    adviceId = adviceId,
    doctorName = doctorName ,
    phoneDoctor = phoneDoctor,
    profileDoctor = profileDoctor ,
    doctorLocation = profileLocation,
    age = age
)
