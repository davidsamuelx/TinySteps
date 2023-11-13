package com.aa.base.viewmodels.cateories.specialcase

import androidx.lifecycle.SavedStateHandle
import com.aa.base.viewmodels.cateories.sleepposition.SleepDetailsArgs

class SpecialCaseDetailsArgs (savedStateHandle: SavedStateHandle) {
    val id: String = savedStateHandle[SleepDetailsArgs.ID_ARG] ?: "0"

    companion object {
        const val ID_ARG = "id"
    }
}