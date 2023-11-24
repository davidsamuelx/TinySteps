package com.aa.usecase

import com.aa.models.ValidationResult
import com.aa.usecase.validations.ValidatePasswordUseCase
import com.aa.usecase.validations.ValidateUsernameUseCase
import javax.inject.Inject

class ValidateLoginFormUseCase @Inject constructor(

    private val validateUsername: ValidateUsernameUseCase,
    private val validatePassword: ValidatePasswordUseCase,
) {
    operator fun invoke(
        userName: String,
        password: String
    ): List<ValidationResult> {
        return listOf(
            validateUsername(userName),
            validatePassword(password)
        )
    }
}