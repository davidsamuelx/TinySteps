package com.aa.usecase.validations

import com.aa.models.ValidationResult
import javax.inject.Inject

class ValidateFullNameUseCase @Inject constructor() {
    operator fun invoke(fullName: String): ValidationResult {
        return if (fullName.isBlank() || fullName.isEmpty()) {
            ValidationResult(false, ERROR)
        } else if (fullName.length < MINIMUM_LENGTH) {
            ValidationResult(false, ERROR_LENGTH_SHORT)
        } else if (fullName.length > MAXIMUM_LENGTH) {
            ValidationResult(false, ERROR_LENGTH_LARGE)
        } else if (!Regex("^[a-zA-Z\\-]+$").matches(fullName)) {
            ValidationResult(false, ERROR_LETTER)
        } else {
            ValidationResult(true, "")
        }
    }


    companion object {
        private const val MINIMUM_LENGTH = 6
        private const val MAXIMUM_LENGTH = 250
        private const val ERROR_LENGTH_SHORT = "Please write at least 6 length of full name"
        private const val ERROR_LENGTH_LARGE = "Please write at most 250 length of full name"
        private const val ERROR_LETTER = "The user name must be only letters or dash"
        private const val ERROR = "Please enter a full name"

    }
}
