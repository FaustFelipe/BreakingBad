package com.android.truelogic.domain.di

import com.android.truelogic.domain.usecases.IMainUseCase
import com.android.truelogic.domain.usecases.MainUseCase
import org.koin.dsl.module

val domainModule = module {
    single<IMainUseCase> { MainUseCase(repository = get()) }
}