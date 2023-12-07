package com.aa.viewmodels.exercise

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.ExerciseEntity

data class ExerciseDetailsUiState(
    val exercise: ExerciseDetailsItemUiState = ExerciseDetailsItemUiState(),
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
): BaseUiState

data class ExerciseDetailsItemUiState(
    val id: Int = 0,
    val videoUrl: String = "",
    val videoName: String = "",
    val videoDescription: String = "",
    val imageUrl: String = ""
)

fun ExerciseEntity.toDetailsUiState() = ExerciseDetailsItemUiState(
    id = id,
    videoUrl = videoUrl,
    videoName = videoName,
    videoDescription = videoDescription,
    imageUrl = imageUrl,
)

