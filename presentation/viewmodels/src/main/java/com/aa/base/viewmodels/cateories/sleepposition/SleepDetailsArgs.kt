package com.aa.base.viewmodels.cateories.sleepposition

import androidx.lifecycle.SavedStateHandle

class SleepDetailsArgs (savedStateHandle: SavedStateHandle){
    val id: String = savedStateHandle[ID_ARG] ?: "0"

    companion object {
        const val ID_ARG = "id"
    }
}