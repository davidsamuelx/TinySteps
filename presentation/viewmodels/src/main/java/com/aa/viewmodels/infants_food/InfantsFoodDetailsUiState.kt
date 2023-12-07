package com.aa.viewmodels.infants_food

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.InfantsFoodEntity

data class InfantsFoodDetailsUiState(
    val food:  InfantsFoodItemDetailsUiState =  InfantsFoodItemDetailsUiState(),
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
):BaseUiState

data class  InfantsFoodItemDetailsUiState(
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

fun InfantsFoodEntity.toDetailsUiState() =  InfantsFoodItemDetailsUiState(
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