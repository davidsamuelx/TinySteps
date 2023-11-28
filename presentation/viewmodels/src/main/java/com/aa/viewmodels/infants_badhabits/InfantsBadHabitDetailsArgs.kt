package com.aa.viewmodels.infants_badhabits

import androidx.lifecycle.SavedStateHandle


class InfantsBadHabitDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: Int = savedStateHandle[ID_ARG] ?: 0

    companion object {
        const val ID_ARG = "id"
    }
}