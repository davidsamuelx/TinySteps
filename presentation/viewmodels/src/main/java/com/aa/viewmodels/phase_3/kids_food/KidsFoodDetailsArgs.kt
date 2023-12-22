package com.aa.viewmodels.phase_3.kids_food

import androidx.lifecycle.SavedStateHandle

class KidsFoodDetailsArgs(savedStateHandle: SavedStateHandle){
    val id: String = savedStateHandle[ID_ARG] ?:"0"

    companion object {
        const val ID_ARG = "id"
    }
}