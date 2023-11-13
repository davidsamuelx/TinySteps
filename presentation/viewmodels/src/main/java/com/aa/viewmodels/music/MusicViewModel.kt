package com.aa.viewmodels.music

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.MusicEntity
import com.aa.usecase.GetAllMusicUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val getAllMusicUseCase: GetAllMusicUseCase
): BaseViewModel<MusicUiState>(MusicUiState()){

    init {
        getMusic()
    }

    private fun getMusic(){
        println(getAllMusicUseCase)
        _state.update { it.copy(isLoading = true) }
        tryToExecute (
            { getAllMusicUseCase() },
            ::onGetAllMusicSuccess,
            ::onError
        )
    }

    private fun onGetAllMusicSuccess(allMusic: List<MusicEntity>){
        val music = allMusic.map { it.toUiState() }
        println(allMusic)
        _state.update {
            it.copy(
                isLoading = false,
                musicList = music
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}