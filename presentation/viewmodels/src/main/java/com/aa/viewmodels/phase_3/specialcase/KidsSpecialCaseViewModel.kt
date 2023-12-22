package com.aa.viewmodels.phase_3.specialcase

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.kids.KidsSpecialCaseEntity
import com.aa.usecase.kids.GetIAllKidsSpecialCaseUseCase
import com.aa.usecase.kids.SearchKidsSpecialCaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KidsSpecialCaseViewModel @Inject constructor(
    private val getIAllKidsSpecialCaseUseCase: GetIAllKidsSpecialCaseUseCase,
    private val searchKidsSpecialCaseUseCase: SearchKidsSpecialCaseUseCase
): BaseViewModel<KidsSpecialCaseUIState>(KidsSpecialCaseUIState()){

    private var searchJob: Job? = null

    init {
        getSpecialCases()
    }

    fun onQueryChange(newQuery: String) {
        _state.update { it.copy(query = newQuery) }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(300)
            onSpecialCaseSearchClicked()
        }
    }

    private fun getSpecialCases(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getIAllKidsSpecialCaseUseCase()},
            ::onGetSpecialCaseSuccess,
            ::onError
        )
    }
    private fun onGetSpecialCaseSuccess(specialCase: List<KidsSpecialCaseEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                specialCasesList = specialCase.map {
                        specialCaseEntity -> specialCaseEntity.toUiState()
                }
            )
        }
    }
    fun onSpecialCaseSearchClicked(){
        val currentQuery = _state.value.query
        if (currentQuery.isNotEmpty()) {
            _state.update { it.copy(isLoading = true) }
            tryToExecute(
                { searchKidsSpecialCaseUseCase(currentQuery) },
                ::onSpecialCaseSearchSuccess,
                ::onError
            )
        }else {
            getSpecialCases()
        }
    }
    private fun onSpecialCaseSearchSuccess(searchList: List<KidsSpecialCaseEntity>){
        _state.update {
            it.copy(
                isLoading = false,
                specialCasesList = searchList.map { searchSpecialCaseEntity ->
                    searchSpecialCaseEntity.toUiState()
                }
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }
}