package com.aa.viewmodels.phase_3.kids_food

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.kids.KidsFoodEntity

data class KidsFoodUIState(
    val foodUIState: List<KidsFoodItemUIState> = emptyList(),
    val query: String = "",
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
): BaseUiState

data class KidsFoodItemUIState(
    val id:Int? =0,
    val detailsOfFood: String? ="",
    val imgFood: String? ="",
    val nameFood: String? ="",
    val doctorName: String? ="",
    val nameProblem: String? ="",
    val phoneDoctor: String? ="",
    val profileDoctor: String? ="",
    val solveProblem: String? ="",
    val doctorLocation:String? ="",
    val specificFood: String? = ""
)

fun KidsFoodEntity.toUiState() = KidsFoodItemUIState(
    id = id,
    nameFood = nameFood,
    imgFood = imgFood,
    detailsOfFood = detailsOfFood,
    doctorName = doctorName,
    nameProblem = nameProblem,
    phoneDoctor = phoneDoctor,
    solveProblem = solveProblem,
    profileDoctor = profileDoctor,
    doctorLocation = doctorLocation,
    specificFood = specificFood,

)