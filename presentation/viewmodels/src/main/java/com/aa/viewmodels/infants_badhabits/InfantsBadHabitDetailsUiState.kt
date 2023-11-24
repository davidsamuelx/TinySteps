package com.aa.viewmodels.infants_badhabits

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.InfantsBadHabitsEntity

data class InfantsBadHabitDetailsUiState(
    val badHabit: InfantsBadHabitItemDetailsUIState = InfantsBadHabitItemDetailsUIState(),
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
): BaseUiState

data class InfantsBadHabitItemDetailsUIState(
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

fun InfantsBadHabitsEntity.toDetailsUiState() = InfantsBadHabitItemDetailsUIState(
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