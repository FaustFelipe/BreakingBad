package com.android.truelogic.BreakingBad

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel(mainUseCase = get())
    }

}