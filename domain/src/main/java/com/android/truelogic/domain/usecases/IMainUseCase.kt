package com.android.truelogic.domain.usecases

import com.android.truelogic.domain.models.Character
import com.android.truelogic.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface IMainUseCase {
    fun getCharacters(): Flow<Result<List<Character>>>
}