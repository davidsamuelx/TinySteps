package com.aa.viewmodels.badhabit

import androidx.lifecycle.SavedStateHandle


class BadHabitDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: Int = savedStateHandle[ID_ARG] ?: 0

    companion object {
        const val ID_ARG = "id"
    }
}