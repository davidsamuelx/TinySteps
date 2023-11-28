package com.aa.viewmodels.infants_sleep_position

import androidx.lifecycle.SavedStateHandle

class InfantsSleepDetailsArgs (savedStateHandle: SavedStateHandle){
    val id: String = savedStateHandle[ID_ARG] ?: "0"

    companion object {
        const val ID_ARG = "id"
    }
}