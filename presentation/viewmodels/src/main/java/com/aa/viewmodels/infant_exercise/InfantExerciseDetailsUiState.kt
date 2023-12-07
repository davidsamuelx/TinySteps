package com.aa.viewmodels.infant_exercise

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.InfantsExerciseEntity

data class InfantExerciseDetailsUiState(
    val exercise: InfantExerciseDetailsItemUiState = InfantExerciseDetailsItemUiState(),
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
): BaseUiState

data class InfantExerciseDetailsItemUiState(
    val id: Int = 0,
    val videoUrl: String = "",
    val videoName: String = "",
    val videoDescription: String = "",
    val imageUrl: String = ""
)

fun InfantsExerciseEntity.toDetailsUiState() = InfantExerciseDetailsItemUiState(
    id = id ?: 0,
    videoUrl = pathVideo ?: "",
    videoDescription = detailsEn ?: "",
    imageUrl = exerciseImg ?: "",
    videoName = name ?: "",
)