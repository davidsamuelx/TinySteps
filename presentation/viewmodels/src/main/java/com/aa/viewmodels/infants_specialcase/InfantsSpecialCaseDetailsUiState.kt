package com.aa.viewmodels.infants_specialcase

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.InfantsSpecialCaseEntity

data class InfantsSpecialCaseDetailsUiState(
    val specialCase: InfantsSpecialCaseDetailsItemUiState = InfantsSpecialCaseDetailsItemUiState(),
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
): BaseUiState

data class InfantsSpecialCaseDetailsItemUiState(
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

fun InfantsSpecialCaseEntity.toDetailsUiState() = InfantsSpecialCaseDetailsItemUiState(
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