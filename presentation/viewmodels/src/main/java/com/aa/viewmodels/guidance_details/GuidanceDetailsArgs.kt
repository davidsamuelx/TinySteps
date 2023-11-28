package com.aa.viewmodels.guidance_details

import androidx.lifecycle.SavedStateHandle

class GuidanceDetailsArgs(savedStateHandle: SavedStateHandle){
    val id: String = savedStateHandle[ID_ARG] ?: "0"

    companion object{
        const val ID_ARG = "id"
    }
}