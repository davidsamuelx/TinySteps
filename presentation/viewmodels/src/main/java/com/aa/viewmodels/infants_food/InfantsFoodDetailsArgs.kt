package com.aa.viewmodels.infants_food

import androidx.lifecycle.SavedStateHandle

class InfantsFoodDetailsArgs(savedStateHandle: SavedStateHandle){
    val id: String = savedStateHandle[ID_ARG] ?:"0"

    companion object {
        const val ID_ARG = "id"
    }
}