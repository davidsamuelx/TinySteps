package com.aa.base.viewmodels.cateories.food

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.SearchFoodEntity

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
)

fun SearchFoodEntity.toUiState() = FoodItemDetailsUiState(
    adviceId = adviceId ?: 0,
    nameFood = nameFood ?: "",
    imgFood = imgFood ?: "",
    detailsOfFood = detailsOfFood ?: "",
    doctorName = doctorName ?: "",
    nameProblem = nameProblem ?: "",
    phoneDoctor = phoneDoctor ?: "",
    solveProblem = solveProblem ?: "",

    )