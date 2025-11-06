package com.arjesh.boxboxassignment.domain.util

sealed class NetworkException(message: String) : Exception(message) {
    class NoInternet : NetworkException("No internet connection")
    class Timeout : NetworkException("Request timeout")
    class Unauthorized : NetworkException("Unauthorized access")
    class NotFound : NetworkException("Resource not found")
    class ServerError(code: Int) : NetworkException("Server error: $code")
    class Unknown(error: String) : NetworkException("Unknown error: $error")
}