package com.aa.base.viewmodels.cateories.specialcase

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.SpecialCaseByIdEntity

data class SpecialCaseDetailsUiState(
    val specialCase: SpecialCaseDetailsItemUiState = SpecialCaseDetailsItemUiState(),
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
): BaseUiState

data class SpecialCaseDetailsItemUiState(
    val id: Int = 0,
    val details: String = "",
    val nameSpecialCase: String = "",
    val pathImg: String = "",
    val adviceId: Int = 0,
    val doctorName: String = "",
    val phoneDoctor: String = "",
    val profileDoctor: String = "",
    val solveProblem: String = "",
    val doctorLocation: String = "",
)

fun SpecialCaseByIdEntity.toUiState() = SpecialCaseDetailsItemUiState(
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