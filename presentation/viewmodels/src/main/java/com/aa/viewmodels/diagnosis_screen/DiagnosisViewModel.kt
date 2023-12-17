package com.aa.viewmodels.diagnosis_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.DiagnosisEntity
import com.aa.usecase.diagnosis.AutoCompleteSymptomUseCase
import com.aa.usecase.diagnosis.GetDiagnosisUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DiagnosisViewModel @Inject constructor(
    private val getDiagnosisUseCase: GetDiagnosisUseCase,
    private val autoCompleteSymptomUseCase: AutoCompleteSymptomUseCase
) : BaseViewModel<DiagnosisUiState>(DiagnosisUiState()) {

    fun onFirstSymptomChange(query: CharSequence) {
        val autoCompleteQuery = autoCompleteSymptomUseCase(query.toString())
        _state.update {
            it.copy(
                firstSymptom = autoCompleteQuery,
            )
        }
    }

    fun onSecondSymptomChange(query: CharSequence) {
        val autoCompleteQuery = autoCompleteSymptomUseCase(query.toString())
        _state.update {
            it.copy(
                secondSymptom = autoCompleteQuery,
            )
        }
    }

    fun onThirdSymptomChange(query: CharSequence) {
        val autoCompleteQuery = autoCompleteSymptomUseCase(query.toString())
        _state.update {
            it.copy(
                thirdSymptom = autoCompleteQuery,
            )
        }
    }

    fun onFourthSymptomChange(query: CharSequence) {
        val autoCompleteQuery = autoCompleteSymptomUseCase(query.toString())
        _state.update {
            it.copy(
                fourthSymptom = autoCompleteQuery,
            )
        }
    }

    fun onFifthSymptomChange(query: CharSequence) {
        val autoCompleteQuery = autoCompleteSymptomUseCase(query.toString())
        _state.update {
            it.copy(
                fifthSymptom = autoCompleteQuery,
            )
        }
    }

    fun onDiagnosisClicked() {
        tryToExecute(
            {
                getDiagnosisUseCase(
                    _state.value.firstSymptom,
                    _state.value.secondSymptom,
                    _state.value.thirdSymptom,
                    _state.value.fourthSymptom,
                    _state.value.fifthSymptom
                )
            },
            ::onDiagnosisSuccess,
            ::onError
        )
    }

    private fun onDiagnosisSuccess(response: DiagnosisEntity?) {
        _state.update { state ->
            state.copy(
                isLoading = false,
                isError = false,
                firstSymptom = "",
                secondSymptom = "",
                thirdSymptom = "",
                fourthSymptom = "",
                fifthSymptom = "",
                diagnosis = response!!.name,
                cause = response.cause,
                treatment = response.treatment,
                percentage = response.percentage.toString()
            )
        }
    }

    private fun onError(error: BaseErrorUiState) {
        _state.update { state ->
            state.copy(
                isLoading = false,
                isError = true,
                error = error
            )
        }
    }

}