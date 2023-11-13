package com.aa.base.viewmodels.cateories.badhabit

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.BadHabitEntity

data class BadHabitUIState(
    val badHabitsList: List<BadHabitItemUIState> = emptyList(),
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
):BaseUiState


data class BadHabitItemUIState(
    val id: Int = 0,
    val details: String = "",
    val nameBadHabit: String = "",
    val pathImg: String = "",
    val adviceId: Int = 0,
    val doctorName: String = "",
    val phoneDoctor: String = "",
    val profileDoctor: String = "",
    val solveProblem: String = ""
)

fun BadHabitEntity.toUiState() = BadHabitItemUIState(
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
