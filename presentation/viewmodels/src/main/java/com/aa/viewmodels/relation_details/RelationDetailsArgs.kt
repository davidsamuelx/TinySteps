package com.aa.viewmodels.relation_details

import androidx.lifecycle.SavedStateHandle

class RelationDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: String = savedStateHandle[ID_ARG] ?: "0"

    companion object{
        const val ID_ARG = "id"
    }
}