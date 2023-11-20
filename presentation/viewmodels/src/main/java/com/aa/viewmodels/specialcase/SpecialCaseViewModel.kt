package com.aa.viewmodels.specialcase

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.SpecialCaseEntity
import com.aa.usecase.GetAllSpecialCasesUseCase
import com.aa.usecase.SearchSpecialCaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpecialCaseViewModel @Inject constructor(
    private val getAllSpecialCases: GetAllSpecialCasesUseCase,
    private val searchSpecialCaseUseCase: SearchSpecialCaseUseCase
): BaseViewModel<SpecialCaseUIState>(SpecialCaseUIState()){

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
            {getAllSpecialCases()},
            ::onGetSpecialCaseSuccess,
            ::onError
        )
    }

    private fun onGetSpecialCaseSuccess(specialCase: List<SpecialCaseEntity>){
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
                { searchSpecialCaseUseCase(currentQuery) },
                ::onSpecialCaseSearchSuccess,
                ::onError
            )
        }else {
            getSpecialCases()
        }
    }

    private fun onSpecialCaseSearchSuccess(searchList: List<SpecialCaseEntity>){
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