package com.aa.base

import com.aa.models.ValidationResult

sealed class BaseErrorUiState(val errorCode: String) {
    class NetworkError(val error: String) : BaseErrorUiState(error )

    class Disconnected(val error: String) : BaseErrorUiState(error)

    class UnAuthorized(val validationResults: List<ValidationResult>) :
        BaseErrorUiState("Invalid Input")


    class ServerError(val error: String) : BaseErrorUiState(error)

    class NoFoundError(val error: String) : BaseErrorUiState(error)

    data class InvalidPassword(val errorMessage: String) : BaseErrorUiState(errorMessage)

    data class InvalidUserName(val errorMessage: String) : BaseErrorUiState(errorMessage)

    data class UserNotExist(val errorMessage: String) : BaseErrorUiState(errorMessage)

    data class UsernameCannotBeBlank(val errorMessage: String) : BaseErrorUiState(errorMessage)

    data class MultipleErrors(val errors: List<BaseErrorUiState>) : BaseErrorUiState("Invalid Input")

}
