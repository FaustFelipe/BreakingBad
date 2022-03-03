package com.android.truelogic.BreakingBad

import android.app.Application
import com.android.truelogic.data.di.networkModule
import com.android.truelogic.data.di.repositoryModule
import com.android.truelogic.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class DoAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    override fun onTerminate() {
        super.onTerminate()

        stopKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@DoAppApplication)
            koin.loadModules(
                listOf(
                    networkModule,
                    repositoryModule,
                    domainModule,
                    viewModelModule,
                )
            )
        }
    }

}