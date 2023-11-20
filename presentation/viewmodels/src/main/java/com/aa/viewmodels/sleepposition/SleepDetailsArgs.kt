package com.aa.viewmodels.sleepposition

import androidx.lifecycle.SavedStateHandle

class SleepDetailsArgs (savedStateHandle: SavedStateHandle){
    val id: String = savedStateHandle[ID_ARG] ?: "0"

    companion object {
        const val ID_ARG = "id"
    }
}