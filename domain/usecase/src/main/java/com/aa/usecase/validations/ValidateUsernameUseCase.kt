package com.aa.usecase.validations

import com.aa.models.ValidationResult

import javax.inject.Inject

class ValidateUsernameUseCase @Inject constructor() {
    operator fun invoke(username: String): ValidationResult {
        return if (username.isEmpty() || username.isBlank()) {
            ValidationResult(false, ERROR)
        } else if (username.length < MINIMUM_LENGTH) {
            ValidationResult(false, ERROR_LENGTH_SHORT)
        } else if (username.length > MAXIMUM_LENGTH) {
            ValidationResult(false, ERROR_LENGTH_LARGE)
        } else if (!Regex("^[a-zA-Z\\-]+$").matches(username)) {
            ValidationResult(false, ERROR_LETTER)
        } else {
            ValidationResult(true, "")
        }
    }

    companion object {
        private const val MINIMUM_LENGTH = 3
        private const val MAXIMUM_LENGTH = 250
        private const val ERROR_LENGTH_SHORT = "Please write at least 3 length of username"
        private const val ERROR_LENGTH_LARGE = "Please write at most 250 length of username"
        private const val ERROR_LETTER = "The user name must be only letters or dash"
        private const val ERROR = "Please enter a user name"

    }
}