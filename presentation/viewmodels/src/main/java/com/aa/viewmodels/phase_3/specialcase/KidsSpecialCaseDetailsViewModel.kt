package com.aa.viewmodels.phase_3.specialcase

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.kids.KidsSpecialCaseEntity
import com.aa.usecase.kids.SelectKidsSpecialCaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class KidsSpecialCaseDetailsViewModel@Inject constructor(
    private val selectKidsSpecialCaseUseCase: SelectKidsSpecialCaseUseCase,
    savedStateHandle: SavedStateHandle
): BaseViewModel<KidsSpecialCaseDetailsUiState>(KidsSpecialCaseDetailsUiState()){

    private val args: KidsSpecialCaseDetailsArgs = KidsSpecialCaseDetailsArgs(savedStateHandle)

    init {
        getSpecialCaseDetails()
    }
    private fun getSpecialCaseDetails(){
        val id = args.id.toInt()
        tryToExecute(
            { selectKidsSpecialCaseUseCase(id) },
            ::onGetSpecialCaseDetailsSuccess,
            ::onError
        )
    }

    private fun onGetSpecialCaseDetailsSuccess(special: KidsSpecialCaseEntity){
        _state.update {
            it.copy(
                isLoading = false,
                specialCase = special.toDetailsUiState()
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}