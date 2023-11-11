package com.aa.base.viewmodels.cateories.food

import androidx.lifecycle.SavedStateHandle

class FoodDetailsArgs(savedStateHandle: SavedStateHandle){
    val id: String = savedStateHandle[ID_ARG] ?: "0"

    companion object {
        const val ID_ARG = "id"
    }
}