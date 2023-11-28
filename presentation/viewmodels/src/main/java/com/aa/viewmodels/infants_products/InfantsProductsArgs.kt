package com.aa.viewmodels.infants_products

import androidx.lifecycle.SavedStateHandle

class InfantsProductsArgs (savedStateHandle: SavedStateHandle){
    val id: String = savedStateHandle[ID_ARG] ?: "0"

    companion object {
        const val ID_ARG = "id"
    }
}