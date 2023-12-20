package com.aa.viewmodels.diagnosis_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState

data class DiagnosisUiState(
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null,
    val isError: Boolean = false,
    val firstSymptom: String = "",
    val secondSymptom: String = "",
    val thirdSymptom: String = "",
    val fourthSymptom: String = "",
    val fifthSymptom: String = "",
    val diagnosis : String = "",
    val cause : String = "",
    val percentage : String = "",
    val treatment : List<String> = emptyList(),
):BaseUiState
