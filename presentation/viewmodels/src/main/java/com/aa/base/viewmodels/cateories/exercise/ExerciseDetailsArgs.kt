package com.aa.base.viewmodels.cateories.exercise

import androidx.lifecycle.SavedStateHandle

class ExerciseDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: Int = savedStateHandle[ID_ARG] ?: 0

    companion object {
        const val ID_ARG = "id"
    }
}