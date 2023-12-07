package com.aa.viewmodels.exercise

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.ExerciseEntity

data class ExercisesUiState(
    val exercisesList: List<ExercisesItemUiState> = emptyList(),
    val query: String = "",
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
): BaseUiState

data class ExercisesItemUiState(
    val id: Int = 0,
    val videoUrl: String = "",
    val videoName: String = "",
    val videoDescription: String = "",
    val imageUrl: String = ""
)

fun ExerciseEntity.toUiState() = ExercisesItemUiState(
    id = id,
    videoUrl = videoUrl,
    videoName = videoName,
    videoDescription = videoDescription,
    imageUrl = imageUrl,
)
