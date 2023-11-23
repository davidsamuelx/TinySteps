package com.aa.viewmodels.infants_food

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.InfantsFoodEntity

data class InfantsFoodUIState(
    val foodUIState: List<InfantsFoodItemUIState> = emptyList(),
    val query: String = "",
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
): BaseUiState

data class InfantsFoodItemUIState(
    val adviceId: Int = 0,
    val detailsOfFood: String = "",
    val doctorName: String = "",
    val imgFood: String = "",
    val nameFood: String = "",
    val nameProblem: String = "",
    val phoneDoctor: String = "",
    val solveProblem: String = "",
)

fun InfantsFoodEntity.toUiState() = InfantsFoodItemUIState(
    adviceId = adviceId,
    nameFood = nameFood,
    imgFood = imgFood,
    detailsOfFood = detailsOfFood,
    doctorName = doctorName,
    nameProblem = nameProblem,
    phoneDoctor = phoneDoctor,
    solveProblem = solveProblem,

)