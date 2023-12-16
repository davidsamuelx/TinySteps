package com.aa.viewmodels.education

import androidx.lifecycle.SavedStateHandle

class EducationDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: Int = savedStateHandle[ID_ARG] ?: 0

    companion object {
        const val ID_ARG = "ID"
    }
}