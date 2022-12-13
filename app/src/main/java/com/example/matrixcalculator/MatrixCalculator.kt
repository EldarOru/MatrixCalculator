package com.example.matrixcalculator

import java.util.*

abstract class MatrixCalculator(
    protected val stack: Stack<Pair<Command, ResultState>>
) {

    abstract fun executeCommand(command: Command): ResultState

    abstract fun undo(): ResultState

    abstract fun showLastStack(): Pair<Command, ResultState>

    class Base(
        stack: Stack<Pair<Command, ResultState>>
    ) : MatrixCalculator(stack) {
        override fun executeCommand(command: Command): ResultState {
            val result = try {
                ResultState.SuccessState(command.execute())
            } catch (e: IllegalMatrixSize) {
                ResultState.ErrorState("err")
            }
            stack.push(Pair(command, result))
            return result
        }

        override fun undo(): ResultState {
            return stack.pop().second
        }

        override fun showLastStack(): Pair<Command, ResultState> {
            return stack.peek()
        }
    }
}


