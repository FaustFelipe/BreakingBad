package com.android.truelogic.domain.usecases

import com.android.truelogic.domain.models.Character
import com.android.truelogic.domain.repository.BreakingBadRepository
import com.android.truelogic.domain.utils.Result
import kotlinx.coroutines.flow.Flow

class MainUseCase(
    private val repository: BreakingBadRepository
): IMainUseCase {

    override fun getCharacters(): Flow<Result<List<Character>>> {
        return repository.getCharacters()
    }
}