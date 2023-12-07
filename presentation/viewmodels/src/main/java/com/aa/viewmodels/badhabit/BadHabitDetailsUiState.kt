package com.aa.viewmodels.badhabit

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.BadHabitEntity

data class BadHabitDetailsUiState(
    val badHabit: BadHabitItemDetailsUIState = BadHabitItemDetailsUIState(),
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
): BaseUiState

data class BadHabitItemDetailsUIState(
    val id: Int = 0,
    val details: String = "",
    val nameBadHabit: String = "",
    val pathImg: String = "",
    val adviceId: Int = 0,
    val doctorName: String = "",
    val phoneDoctor: String = "",
    val profileDoctor: String = "",
    val solveProblem: String = "",
    val doctorLocation: String = "",
)

fun BadHabitEntity.toDetailsUiState() = BadHabitItemDetailsUIState(
    id = iD ?: 0,
    details = details ?: "",
    nameBadHabit = nameBadHabit ?: "" ,
    pathImg = pathImg ?: "",
    adviceId = adviceId ?: 0,
    doctorName = doctorName ?: "",
    phoneDoctor = phoneDoctor ?: "",
    profileDoctor = profileDoctor ?: "",
    solveProblem = solveProblem ?: "",
)