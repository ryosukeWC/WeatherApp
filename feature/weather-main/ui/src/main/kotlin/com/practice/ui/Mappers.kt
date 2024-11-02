package com.practice.ui

fun Result<Any>.toUiState() : State {
    return when {
        isFailure -> State.Error(this.exceptionOrNull()?.message ?: "Unknown exception")
        isSuccess -> State.Success(this.getOrThrow())
        else -> State.None
    }
}