package com.aa.base

sealed class BaseErrorUiState(val errorCode: String) {
    class NetworkError(val error: String) : BaseErrorUiState(error)
}
