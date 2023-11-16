package com.aa.viewmodels.music

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.MusicEntity
import com.aa.usecase.GetAllMusicUseCase
import com.aa.usecase.SearchMusicByTypeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val getAllMusicUseCase: GetAllMusicUseCase,
    private val searchMusicByTypeUseCase: SearchMusicByTypeUseCase
): BaseViewModel<MusicUiState>(MusicUiState()){

    private var searchJob: Job? = null

    init {
        getMusic()
    }

    fun onQueryChange(newQuery: String) {
        _state.update { it.copy(query = newQuery) }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(300)
            onMusicSearchClicked()
        }
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


    fun onMusicSearchClicked() {
        val currentQuery = _state.value.query
        if (currentQuery.isNotEmpty()) {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { searchMusicByTypeUseCase(currentQuery) },
                ::onMusicSearchSuccess,
                ::onError
            )
        }else {
            getMusic()
        }
    }


    private fun onMusicSearchSuccess(searchResults: List<MusicEntity>) {
        _state.update {
            it.copy(
                isLoading = false,
                musicList = searchResults.map { musicSearchEntity ->
                    musicSearchEntity.toUiState()
                }
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}