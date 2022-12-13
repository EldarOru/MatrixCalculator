package com.example.matrixcalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val matrixCalculator: MatrixCalculator
): ViewModel() {

    private val mutableLiveData = MutableLiveData<ResultState>()
    val liveData: LiveData<ResultState>
        get() = mutableLiveData

    init {
        mutableLiveData.value = ResultState.Default
    }

    fun calculate(command: Command) {
        mutableLiveData.value = matrixCalculator.executeCommand(command)
    }
}