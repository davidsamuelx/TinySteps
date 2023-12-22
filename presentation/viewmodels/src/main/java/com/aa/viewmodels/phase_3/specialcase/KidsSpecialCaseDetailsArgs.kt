package com.aa.viewmodels.phase_3.specialcase

import androidx.lifecycle.SavedStateHandle
import com.aa.viewmodels.sleepposition.SleepDetailsArgs

class KidsSpecialCaseDetailsArgs (savedStateHandle: SavedStateHandle) {
    val id: String = savedStateHandle[SleepDetailsArgs.ID_ARG] ?: "0"

    companion object {
        const val ID_ARG = "id"
    }
}