package com.aa.viewmodels.infant_exercise

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.InfantsExerciseEntity

data class InfantExerciseUiState(
    val exercisesList: List<InfantExercisesItemUiState> = emptyList(),
    val query: String = "",
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
): BaseUiState


data class InfantExercisesItemUiState(
    val id: Int = 0,
    val videoUrl: String = "",
    val videoName: String = "",
    val videoDescription: String = "",
    val imageUrl: String = ""
)

fun InfantsExerciseEntity.toUiState() = InfantExercisesItemUiState(
    id = id ?: 0,
    videoUrl = pathVideo ?: "",
    videoDescription = detailsEn ?: "",
    imageUrl = exerciseImg ?: "",
    videoName = name ?: "",
)