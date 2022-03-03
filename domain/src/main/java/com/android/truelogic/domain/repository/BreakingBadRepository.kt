package com.android.truelogic.domain.repository

import com.android.truelogic.domain.models.Character
import com.android.truelogic.domain.utils.Result
import kotlinx.coroutines.flow.Flow

interface BreakingBadRepository {
    fun getCharacters(): Flow<Result<List<Character>>>
}