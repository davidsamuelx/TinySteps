package com.aa.viewmodels.food

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.AllFoodAdviceEntity

data class FoodUIState(
    val foodUIState: List<FoodItemUIState> = emptyList(),
    val query: String = "",
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
): BaseUiState

data class FoodItemUIState(
    val adviceId:Int = 0 ,
    val detailsOfFood: String = "" ,
    val doctorName: String = "" ,
    val imgFood: String = "" ,
    val nameFood: String = "",
    val nameProblem: String = "",
    val phoneDoctor: String = "",
    val solveProblem: String = "",
)

fun AllFoodAdviceEntity.toUiState() = FoodItemUIState(
    adviceId = adviceId,
    nameFood = nameFood,
    imgFood = imgFood,
    detailsOfFood = detailsOfFood,
    doctorName = doctorName,
    nameProblem = nameProblem,
    phoneDoctor = phoneDoctor,
    solveProblem = solveProblem,

)