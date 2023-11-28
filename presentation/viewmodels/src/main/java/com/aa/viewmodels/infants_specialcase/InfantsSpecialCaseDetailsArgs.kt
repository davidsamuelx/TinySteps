package com.aa.viewmodels.infants_specialcase

import androidx.lifecycle.SavedStateHandle
import com.aa.viewmodels.sleepposition.SleepDetailsArgs

class InfantsSpecialCaseDetailsArgs (savedStateHandle: SavedStateHandle) {
    val id: String = savedStateHandle[SleepDetailsArgs.ID_ARG] ?: "0"

    companion object {
        const val ID_ARG = "id"
    }
}