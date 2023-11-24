package com.aa.models

sealed class ErrorType()  {
    class Network(message: String) : ErrorType()

    class Server(message: String) : ErrorType()

    class UnAuthorized(val validationResults: List<ValidationResult>) : ErrorType()

    class Unknown(message: String) : ErrorType()


}