package com.aa.viewmodels.guidance_details

import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.infants.GuidanceInstructionEntity
import com.aa.usecase.infants.SelectGuidanceInstructionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GuidanceDetailsViewModel @Inject constructor(
    private val selectGuidanceInstructionsUseCase: SelectGuidanceInstructionsUseCase,
    savedStateHandle: SavedStateHandle
): BaseViewModel<GuidanceDetailsUiState>(GuidanceDetailsUiState()){

    private val args: GuidanceDetailsArgs = GuidanceDetailsArgs(savedStateHandle)

    init {
        getGuidanceById()
    }

    private fun getGuidanceById(){
        val id = args.id.toInt()
        tryToExecute(
            { selectGuidanceInstructionsUseCase(id) },
            ::onGetGuidanceDetailsSuccess,
            ::onError
        )
    }

    private fun onGetGuidanceDetailsSuccess(guidance: GuidanceInstructionEntity){
        _state.update {
            it.copy(
                isLoading = false,
                guidance = guidance.toDetailsUiState()
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}