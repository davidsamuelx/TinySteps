package com.aa.viewmodels.music

import androidx.lifecycle.SavedStateHandle

class MusicDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: Int = savedStateHandle[ID_ARG] ?: 0

    companion object {
        const val ID_ARG = "id"
    }
}