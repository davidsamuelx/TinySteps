package com.aa.viewmodels.phase_3.badHabits

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.kids.KidsBadHabitEntity

data class KidsBadHabitDetailsUiState(
    val badHabit: KidsBadHabitItemDetailsUIState = KidsBadHabitItemDetailsUIState(),
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
): BaseUiState

data class KidsBadHabitItemDetailsUIState(
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

fun KidsBadHabitEntity.toDetailsUiState() = KidsBadHabitItemDetailsUIState(
    id = iD ?: 0,
    details = details ?: "",
    nameBadHabit = nameBadHabit ?: "" ,
    pathImg = pathImg ?: "",
    adviceId = adviceId ?: 0,
    doctorName = doctorName ?: "",
    phoneDoctor = phoneDoctor ?: "",
    profileDoctor = profileDoctor ?: "",
    solveProblem = solveProblem ?: "",
    doctorLocation = doctorLocation ?:""
)