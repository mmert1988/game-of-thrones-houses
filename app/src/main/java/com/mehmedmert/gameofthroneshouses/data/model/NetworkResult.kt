package com.mehmedmert.gameofthroneshouses.data.model

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error<T>(val message: String, val error: Throwable? = null) : NetworkResult<T>()
}
