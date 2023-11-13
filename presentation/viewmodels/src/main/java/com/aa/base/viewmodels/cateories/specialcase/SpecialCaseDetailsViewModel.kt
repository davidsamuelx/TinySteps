package com.aa.base.viewmodels.cateories.specialcase

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.SpecialCaseByIdEntity
import com.aa.usecase.GetSpecialCaseByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SpecialCaseDetailsViewModel@Inject constructor(
    private val getSpecialCaseByIdUseCase: GetSpecialCaseByIdUseCase,
    savedStateHandle: SavedStateHandle
): BaseViewModel<SpecialCaseDetailsUiState>(SpecialCaseDetailsUiState()){

    private val args: SpecialCaseDetailsArgs = SpecialCaseDetailsArgs(savedStateHandle)

    init {
        getSpecialCaseDetails()
    }

    private fun getSpecialCaseDetails(){
        val id = args.id.toInt()
        tryToExecute(
            { getSpecialCaseByIdUseCase(id) },
            ::onGetSpecialCaseDetailsSuccess,
            ::onError
        )
    }

    private fun onGetSpecialCaseDetailsSuccess(special: SpecialCaseByIdEntity){
        _state.update {
            it.copy(
                isLoading = false,
                specialCase = special.toUiState()
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}