package com.aa.viewmodels.baby_details_screen

import androidx.lifecycle.SavedStateHandle

class BabyDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: String = savedStateHandle[ID] ?: "0"

    companion object{
        const val ID = "id"
    }
}