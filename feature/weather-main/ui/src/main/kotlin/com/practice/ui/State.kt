package com.practice.ui

sealed class State() {

    data object None : State()

    data object Loading : State()

    data class Error(val exception : String?) : State()

    data class Success<T>(val data : T) : State()
}