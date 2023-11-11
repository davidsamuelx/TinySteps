package com.aa.base.viewmodels.cateories.badhabit

import androidx.lifecycle.SavedStateHandle


class BadHabitDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: String = savedStateHandle[ID_ARG] ?: "0"

    companion object {
        const val ID_ARG = "id"
    }
}