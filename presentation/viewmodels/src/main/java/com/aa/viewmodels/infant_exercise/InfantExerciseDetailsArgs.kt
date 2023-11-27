package com.aa.viewmodels.infant_exercise

import androidx.lifecycle.SavedStateHandle
import com.aa.viewmodels.exercise.ExerciseDetailsArgs

class InfantExerciseDetailsArgs(savedStateHandle: SavedStateHandle)  {
    val id: Int = savedStateHandle[ExerciseDetailsArgs.ID_ARG] ?: 0

    companion object {
        const val ID_ARG = "id"
    }
}