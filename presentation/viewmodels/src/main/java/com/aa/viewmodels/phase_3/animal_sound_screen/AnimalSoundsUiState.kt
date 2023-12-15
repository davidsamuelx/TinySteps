package com.aa.viewmodels.phase_3.animal_sound_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.kids.AnimalGameEntity

data class AnimalSoundsUiState(
    val animalSoundsList: List<AnimalSoundsItemUiState> = emptyList(),
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null,
    val selectedSoundUrl: String = ""

): BaseUiState

data class AnimalSoundsItemUiState(
    val id: Int = 0 ,
    val animalSound: String = "" ,
    val imagePath: String = "" ,
)

fun AnimalGameEntity.toUiState() = AnimalSoundsItemUiState(
    id = id,
    animalSound = sound ?: "",
    imagePath = image,
)