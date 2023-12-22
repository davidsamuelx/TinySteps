package com.aa.viewmodels.phase_3.specialcase

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.kids.KidsSpecialCaseEntity

data class KidsSpecialCaseDetailsUiState(
    val specialCase: KidsSpecialCaseDetailsItemUiState = KidsSpecialCaseDetailsItemUiState(),
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
): BaseUiState

data class KidsSpecialCaseDetailsItemUiState(
    val id: Int? = 0,
    val details: String? = "",
    val nameSpecialCase: String? = "",
    val pathImg: String? = "",
    val adviceId: Int? = 0,
    val doctorName: String? = "",
    val phoneDoctor: String? = "",
    val profileDoctor: String? = "",
    val solveProblem: String? = "",
    val doctorLocation: String? = "",
)

fun KidsSpecialCaseEntity.toDetailsUiState() = KidsSpecialCaseDetailsItemUiState(
    id = iD ,
    details = details ,
    nameSpecialCase = nameSpecialCase  ,
    pathImg = pathImg ,
    adviceId = adviceId ,
    doctorName = doctorName ,
    phoneDoctor = phoneDoctor ,
    profileDoctor = profileDoctor ,
    solveProblem = solveProblem ,
    doctorLocation = doctorLocation
)