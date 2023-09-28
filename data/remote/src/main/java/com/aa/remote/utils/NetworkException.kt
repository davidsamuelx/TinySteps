package com.aa.remote.utils

sealed class NetworkException : Exception() {

    object UnAuthorizedException : NetworkException()

    object NoInternetException : NetworkException()

    object InternalServerError : NetworkException()

    object NotFoundException : NetworkException()

    object ApiKeyExpiredException : NetworkException()

}
