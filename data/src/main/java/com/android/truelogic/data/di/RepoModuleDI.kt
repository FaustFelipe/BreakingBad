package com.android.truelogic.data.di

import com.android.truelogic.data.api.BreakingBadApi
import com.android.truelogic.data.repository.BreakingBadRepositoryImpl
import com.android.truelogic.domain.repository.BreakingBadRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module {

    fun provideRepositoryModule(
        doAppApi: BreakingBadApi,
    ): BreakingBadRepository {
        return BreakingBadRepositoryImpl(doAppApi, Dispatchers.IO)
    }

    single { provideRepositoryModule(doAppApi = get()) }

}