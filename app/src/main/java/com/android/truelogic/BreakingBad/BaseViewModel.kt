package com.android.truelogic.BreakingBad

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    protected val _loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val loadingLiveData: LiveData<Boolean> = _loadingLiveData

    open fun onInit() {
        logCurrentViewModel()
    }

    protected fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                _loadingLiveData.value = true
                block()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _loadingLiveData.value = false
            }
        }
    }

    private fun logCurrentViewModel() {
        if (BuildConfig.DEBUG) {
            val tag = javaClass.simpleName
            Log.d(tag, "Current viewModel is $tag")
        }
    }

}