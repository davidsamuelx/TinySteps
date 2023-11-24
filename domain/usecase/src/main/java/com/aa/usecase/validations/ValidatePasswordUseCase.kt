package com.aa.usecase.validations

import com.aa.models.ValidationResult
import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor() {
    operator fun invoke(password: String): ValidationResult {
        return if (password.isEmpty() || password.isBlank()) {
            ValidationResult(false, ERROR)
        } else if (password.length < MINIMUM_LENGTH) {
            ValidationResult(false, ERROR_LENGTH_SHORT)
        } else if (password.length > MAXIMUM_LENGTH) {
            ValidationResult(false, ERROR_LENGTH_LARGE)
        } else if (!password.any { it.isDigit() }) {
            ValidationResult(false, ERROR_DIGIT)
        } else {
            ValidationResult(true)
        }
    }

    companion object {
        private const val MINIMUM_LENGTH = 6
        private const val MAXIMUM_LENGTH = 250
        private const val ERROR_LENGTH_SHORT = "Please write at least 6 length of password"
        private const val ERROR_LENGTH_LARGE = "Please write at most 8 length of password"
        private const val ERROR_LETTER = "Please write at least 1 letter"
        private const val ERROR_DIGIT = "Please write at least 1 digit"
        private const val ERROR_SPECIAL_CHARACTER = "Please write at least 1 special character"
        private const val ERROR = "Please enter a password"
    }
}
