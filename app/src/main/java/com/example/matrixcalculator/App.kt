package com.example.matrixcalculator

import android.app.Application
import java.util.*

class App : Application(), ProvideViewModel {

    private lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(matrixCalculator = MatrixCalculator.Base(Stack()))
    }

    override fun provide(): MainViewModel = viewModel
}

interface ProvideViewModel {

    fun provide(): MainViewModel
}