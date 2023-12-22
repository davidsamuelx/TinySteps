package com.aa.viewmodels.phase_3.specialcase

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.kids.KidsSpecialCaseEntity

data class KidsSpecialCaseUIState(
    val specialCasesList: List<KidsSpecialCaseItemUIState> = emptyList(),
    val query: String = "",
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
): BaseUiState

data class KidsSpecialCaseItemUIState(
    val id: Int? = 0,
    val details: String? = "",
    val nameSpecialCase: String? = "",
    val pathImg: String? = "",
    val adviceId: Int? = 0,
    val doctorName: String? = "",
    val phoneDoctor: String? = "",
    val profileDoctor: String? = "",
    val solveProblem: String? = ""
)

fun KidsSpecialCaseEntity.toUiState() = KidsSpecialCaseItemUIState(
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