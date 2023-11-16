package com.aa.viewmodels.food

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.AllFoodAdviceEntity

data class FoodDetailsUiState(
    val food: FoodItemDetailsUiState = FoodItemDetailsUiState(),
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
):BaseUiState

data class FoodItemDetailsUiState(
    val adviceId:Int = 0 ,
    val detailsOfFood: String = "" ,
    val doctorName: String = "" ,
    val imgFood: String = "" ,
    val nameFood: String = "",
    val nameProblem: String = "",
    val phoneDoctor: String = "",
    val solveProblem: String = "",
    val doctorLocation: String = "",
)

fun AllFoodAdviceEntity.toDetailsUiState() = FoodItemDetailsUiState(
    adviceId = adviceId,
    nameFood = nameFood ,
    imgFood = imgFood ,
    detailsOfFood = detailsOfFood,
    doctorName = doctorName ,
    nameProblem = nameProblem ,
    phoneDoctor = phoneDoctor ,
    solveProblem = solveProblem ,
    doctorLocation = doctorLocation,
    )