package com.aa.usecase.validations

import com.aa.models.ValidationResult
import javax.inject.Inject

class ValidateStateTitleUseCase @Inject constructor() {
    operator fun invoke(dateTitle: String): ValidationResult {
        return if (dateTitle.isBlank() || dateTitle.isEmpty()) {
            ValidationResult(false, ERROR)
        } else {
            ValidationResult(true)
        }
    }

    companion object {
        private const val ERROR = "Please enter a Date Title"
    }
}
