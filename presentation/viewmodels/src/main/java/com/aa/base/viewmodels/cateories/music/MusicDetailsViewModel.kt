package com.aa.base.viewmodels.cateories.music

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.MusicEntity
import com.aa.usecase.GetMusicByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MusicDetailsViewModel@Inject constructor(
    private val getMusicByIdUseCase: GetMusicByIdUseCase,
    savedStateHandle: SavedStateHandle,
): BaseViewModel<MusicDetailsUiState>(MusicDetailsUiState()) {


    private val args: MusicDetailsArgs = MusicDetailsArgs(savedStateHandle)

    init {
        getMusicById()
    }

    private fun getMusicById(){
        val id = args.id.toInt()
        tryToExecute(
            {getMusicByIdUseCase(id)},
            ::onGetMusicByIdSuccess,
            ::onError
        )
    }


    private fun onGetMusicByIdSuccess(music: MusicEntity){
        _state.update {
            it.copy(
                isLoading = false,
                music = music.toDetailsUiState()
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}