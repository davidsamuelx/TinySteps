package com.aa.viewmodels.education

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.kids.LetterEntity
import com.aa.usecase.kids.GetLetterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EducationDetailsViewModel  @Inject constructor(
    private val getEducationUseCase: GetLetterUseCase,
    savedStateHandle: SavedStateHandle,

    ): BaseViewModel<EducationDetailsUiState>(EducationDetailsUiState()){

    private val args:EducationDetailsArgs= EducationDetailsArgs(savedStateHandle)
    init {
        getEducationById()
    }

    private fun getEducationById(){
        val id = args.id
        tryToExecute(
            {getEducationUseCase(id)},
            ::onGetEducationByIdSuccess,
            ::onError
        )
    }

    private fun onGetEducationByIdSuccess(education: LetterEntity){
        Log.i("letter","$education")
        _state.update {
            it.copy(
                isLoading = false,
                education = education.toDetailsUiState()
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }
}