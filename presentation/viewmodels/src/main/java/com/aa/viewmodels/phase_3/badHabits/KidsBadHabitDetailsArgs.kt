package com.aa.viewmodels.phase_3.badHabits

import androidx.lifecycle.SavedStateHandle


class KidsBadHabitDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: Int = savedStateHandle[ID_ARG] ?: 0

    companion object {
        const val ID_ARG = "id"
    }
}