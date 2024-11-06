package com.practice.weather.data.model

sealed class RequestResult<T>(val data : T? = null, val error : String? = null) {
    class Success<T>(data: T?) : RequestResult<T>(data)
    class Error<T>(message: String? = null) : RequestResult<T>(error = message)
    class Loading<T> : RequestResult<T>()
}