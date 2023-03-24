package com.example.lecture_1a_7.data.base

import com.example.lecture_1a_7.domain.utils.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(ResultStatus.Loading())
        try {
            val data = request()
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.message ?: "Unknown error"))
        }
    }.flowOn(Dispatchers.IO)
}