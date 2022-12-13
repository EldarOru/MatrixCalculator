package com.example.matrixcalculator

abstract class Command(
    protected val firstMatrix: MatrixEntity,
    protected val secondMatrix: MatrixEntity
) {

    abstract fun execute(): MatrixEntity

    //abstract fun undo(): MatrixEntity
}

class SumCommand(
    firstMatrix: MatrixEntity,
    secondMatrix: MatrixEntity,
) : Command(firstMatrix, secondMatrix) {

    override fun execute(): MatrixEntity {
        return firstMatrix.sum(secondMatrix)
    }

}

class DiffCommand(
    firstMatrix: MatrixEntity,
    secondMatrix: MatrixEntity,
) : Command(firstMatrix, secondMatrix) {

    override fun execute(): MatrixEntity {
        return firstMatrix.diff(secondMatrix)
    }

}

class MultiplyCommand(
    firstMatrix: MatrixEntity,
    secondMatrix: MatrixEntity,
) : Command(firstMatrix, secondMatrix) {

    override fun execute(): MatrixEntity {
        return firstMatrix.multiply(secondMatrix)
    }

}