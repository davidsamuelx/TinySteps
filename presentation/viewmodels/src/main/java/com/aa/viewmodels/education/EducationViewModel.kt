package com.aa.viewmodels.education

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.kids.EducationGameEntity
import com.aa.usecase.kids.EducationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EducationViewModel @Inject constructor(
    private val educationUseCase: EducationUseCase
):BaseViewModel<EducationUiState>(EducationUiState()){

    init {
        getEducation()
    }


    private fun getEducation(){
        println(educationUseCase)
        _state.update { it.copy(isLoading = true) }
        tryToExecute (
            { educationUseCase() },
            ::onGetAllEducationSuccess,
            ::onError
        )
    }
    private fun onGetAllEducationSuccess(allEducation: List<EducationGameEntity>){
        val education = allEducation.map { it.toUiState() }
        println(allEducation)
        _state.update {
            it.copy(
                isLoading = false,
                educationList = education,
            )
        }
    }


    private fun onError(errorUIState: BaseErrorUiState){
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}