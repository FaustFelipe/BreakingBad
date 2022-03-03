package com.android.truelogic.domain.utils

sealed class ErrorEntity {
    object Unauthorized: ErrorEntity()
    object ServiceUnavailable: ErrorEntity()
    object Unknown : ErrorEntity()
}

sealed class Result<out T> {
    data class Success<out T>(val data: T): Result<T>()
    data class Error(val errorEntity: ErrorEntity): Result<Nothing>()
}