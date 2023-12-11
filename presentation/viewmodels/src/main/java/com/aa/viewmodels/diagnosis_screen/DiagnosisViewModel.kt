package com.aa.viewmodels.diagnosis_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.DiagnosisEntity
import com.aa.usecase.diagnosis.GetDiagnosisUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DiagnosisViewModel @Inject constructor(
    private val getDiagnosisUseCase: GetDiagnosisUseCase
) : BaseViewModel<DiagnosisUiState>(DiagnosisUiState()) {

    fun onFirstSymptomChange(query: CharSequence) {
        _state.update {
            it.copy(
                firstSymptom = query.toString(),
            )
        }
    }

    fun onSecondSymptomChange(query: CharSequence) {
        _state.update {
            it.copy(
                secondSymptom = query.toString(),
            )
        }
    }

    fun onThirdSymptomChange(query: CharSequence) {
        _state.update {
            it.copy(
                thirdSymptom = query.toString(),
            )
        }
    }

    fun onFourthSymptomChange(query: CharSequence) {
        _state.update {
            it.copy(
                fourthSymptom = query.toString(),
            )
        }
    }

    fun onFifthSymptomChange(query: CharSequence) {
        _state.update {
            it.copy(
                fifthSymptom = query.toString(),
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