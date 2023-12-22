package com.aa.viewmodels.phase_3.animal_sound_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.kids.AnimalGameEntity
import com.aa.usecase.kids.AnimalGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AnimalSoundViewModel @Inject constructor(
    private val getAnimalSoundsUseCase: AnimalGameUseCase
) : BaseViewModel<AnimalSoundsUiState>(AnimalSoundsUiState()) {

    var selectedId by mutableStateOf(-1)

    init {
        getAnimalSounds()
    }

    private fun getAnimalSounds() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAnimalSoundsUseCase(null) },
            ::onGetAnimalSoundsSuccess,
            ::onError
        )
    }

    fun getAnimalSoundById(id: Int) {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAnimalSoundsUseCase(id) },
            ::onGetAnimalSoundByIdSuccess,
            ::onError
        )
    }

    private fun onGetAnimalSoundsSuccess(animalSounds: Any) {
        if (animalSounds is List<*>) {
            _state.update {
                it.copy(
                    isLoading = false,
                    animalSoundsList = (animalSounds as List<AnimalGameEntity>).map { it.toUiState() }
                )
            }
        }
    }

    private fun onGetAnimalSoundByIdSuccess(animalSound: Any) {
        if (animalSound is AnimalGameEntity) {
            selectedId = animalSound.id
            _state.update {
                it.copy(
                    isLoading = false,
                    selectedSoundUrl = animalSound.sound ?: ""
                )
            }
        }
    }

    private fun onError(errorUIState: BaseErrorUiState) {
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }
}