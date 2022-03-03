package com.android.truelogic.data.utils

import com.android.truelogic.domain.utils.ErrorEntity
import retrofit2.Response
import java.net.HttpURLConnection
import com.android.truelogic.domain.utils.Result

internal fun <Y : Any, T : Any> handleResponseCall(call: Response<Y>, result: (Y) -> T): Result<T> {
    return if (call.isSuccessful) {
        val data = call.body()!!
        val dataFormatted = result.invoke(data)
        Result.Success(dataFormatted)
    } else {
        handleApiCodeException(call.code())
    }
}

internal fun handleApiCodeException(code: Int): Result.Error {
    return when (code) {
        HttpURLConnection.HTTP_UNAUTHORIZED, HttpURLConnection.HTTP_FORBIDDEN, 422 -> Result.Error(
            ErrorEntity.Unauthorized
        )
        HttpURLConnection.HTTP_UNAVAILABLE -> Result.Error(ErrorEntity.ServiceUnavailable)
        else -> Result.Error(ErrorEntity.Unknown)
    }
}