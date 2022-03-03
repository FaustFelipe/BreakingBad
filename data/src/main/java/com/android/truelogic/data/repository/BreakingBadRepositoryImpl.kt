package com.android.truelogic.data.repository

import com.android.truelogic.data.api.BreakingBadApi
import com.android.truelogic.data.model.mappers.CharacterMapper
import com.android.truelogic.data.utils.handleResponseCall
import com.android.truelogic.domain.models.Character
import com.android.truelogic.domain.repository.BreakingBadRepository
import com.android.truelogic.domain.utils.ErrorEntity
import com.android.truelogic.domain.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

class BreakingBadRepositoryImpl(
    private val api: BreakingBadApi,
    private val coroutineContext: CoroutineContext
): BreakingBadRepository {

    override fun getCharacters(): Flow<Result<List<Character>>> = flow {
        val response = handleResponseCall(api.getCharacters(10)) { listResponse ->
            listResponse.map { CharacterMapper.map(it) }
        }

        emit(response)
    }
        .catch {
            it.printStackTrace()
            emit(Result.Error(ErrorEntity.Unknown))
        }
        .flowOn(coroutineContext)

}