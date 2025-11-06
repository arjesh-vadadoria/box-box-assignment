package com.arjesh.boxboxassignment.domain.util

sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(
        val exception: Throwable? = null,
        val message: String?
    ) :
        ApiResult<Nothing>()

    object Loading : ApiResult<Nothing>()
}