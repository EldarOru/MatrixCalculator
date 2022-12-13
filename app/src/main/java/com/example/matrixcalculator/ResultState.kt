package com.example.matrixcalculator

import android.widget.TextView

sealed class ResultState {

    abstract fun showInfo(textView: TextView)

    data class SuccessState(private val matrixEntity: MatrixEntity): ResultState() {
        override fun showInfo(textView: TextView) {
            textView.text = matrixEntity.showMatrix()
        }
    }

    data class ErrorState(private val error: String = "err"): ResultState() {
        override fun showInfo(textView: TextView) {
            textView.text = "Error"
        }
    }

    object Default: ResultState() {
        override fun showInfo(textView: TextView) {
            textView.text = "Hello"
        }
    }
}
