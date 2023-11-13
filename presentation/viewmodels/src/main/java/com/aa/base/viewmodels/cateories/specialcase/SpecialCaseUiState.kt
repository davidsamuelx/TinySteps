package com.aa.base.viewmodels.cateories.specialcase

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.base.viewmodels.cateories.badhabit.BadHabitItemUIState
import com.aa.models.SpecialCaseEntity

data class SpecialCaseUIState(
    val specialCasesList: List<SpecialCaseItemUIState> = emptyList(),
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
): BaseUiState

data class SpecialCaseItemUIState(
    val id: Int = 0,
    val details: String = "",
    val nameSpecialCase: String = "",
    val pathImg: String = "",
    val adviceId: Int = 0,
    val doctorName: String = "",
    val phoneDoctor: String = "",
    val profileDoctor: String = "",
    val solveProblem: String = ""
)

fun SpecialCaseEntity.toUiState() = SpecialCaseItemUIState(
    id = iD ,
    details = details ,
    nameSpecialCase = nameSpecialCase  ,
    pathImg = pathImg ,
    adviceId = adviceId ,
    doctorName = doctorName ,
    phoneDoctor = phoneDoctor ,
    profileDoctor = profileDoctor ,
    solveProblem = solveProblem ,
)