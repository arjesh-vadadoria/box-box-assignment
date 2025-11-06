package com.arjesh.boxboxassignment.domain.util

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.utils.io.errors.IOException
import java.net.UnknownHostException

object ErrorMapper {
    suspend fun mapException(exception: Throwable): NetworkException {
        return when (exception) {
            is ClientRequestException -> {
                when (exception.response.status.value) {
                    401, 403 -> NetworkException.Unauthorized()
                    404 -> NetworkException.NotFound()
                    in 400..499 -> NetworkException.Unknown("Client error: ${exception.message}")
                    else -> NetworkException.Unknown(exception.message)
                }
            }

            is ServerResponseException -> {
                NetworkException.ServerError(exception.response.status.value)
            }

            is HttpRequestTimeoutException -> NetworkException.Timeout()
            is UnknownHostException, is IOException -> NetworkException.NoInternet()
            else -> NetworkException.Unknown(exception.message ?: "Unknown error")
        }
    }
}