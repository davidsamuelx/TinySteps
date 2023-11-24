package com.aa.viewmodels.infants_specialcase

import androidx.lifecycle.viewModelScope
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.InfantsSpecialCaseEntity
import com.aa.usecase.infants.GetIAllInfantsSpecialCaseUseCase
import com.aa.usecase.infants.SearchInfantsSpecialCaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfantsSpecialCaseViewModel @Inject constructor(
    private val getIAllInfantsSpecialCaseUseCase: GetIAllInfantsSpecialCaseUseCase,
    private val searchInfantsSpecialCaseUseCase: SearchInfantsSpecialCaseUseCase
): BaseViewModel<InfantsSpecialCaseUIState>(InfantsSpecialCaseUIState()){

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
            {getIAllInfantsSpecialCaseUseCase()},
            ::onGetSpecialCaseSuccess,
            ::onError
        )
    }
    private fun onGetSpecialCaseSuccess(specialCase: List<InfantsSpecialCaseEntity>){
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
                { searchInfantsSpecialCaseUseCase(currentQuery) },
                ::onSpecialCaseSearchSuccess,
                ::onError
            )
        }else {
            getSpecialCases()
        }
    }
    private fun onSpecialCaseSearchSuccess(searchList: List<InfantsSpecialCaseEntity>){
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