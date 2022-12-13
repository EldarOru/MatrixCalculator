package com.example.matrixcalculator

interface Operators {

    fun sum(matrixEntity: MatrixEntity): MatrixEntity

    fun diff(matrixEntity: MatrixEntity): MatrixEntity

    fun multiply(matrixEntity: MatrixEntity): MatrixEntity

    fun showMatrix(): String
}

data class MatrixEntity(
    private val numbers: List<List<Int>>,
) : Operators {
    private val rows: Int = numbers.size
    private val columns: Int = numbers[0].size

    private fun returnNumber(i: Int, j: Int) = numbers[i][j]

    override fun sum(matrixEntity: MatrixEntity): MatrixEntity {
        if (rows != matrixEntity.rows || columns != matrixEntity.columns) {
            throw IllegalMatrixSize()
        }
        val result = MutableList(rows) { MutableList(columns) { 0 } }
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                result[i][j] = returnNumber(i, j) + matrixEntity.returnNumber(i, j)
            }
        }
        return MatrixEntity(result)
    }

    override fun diff(matrixEntity: MatrixEntity): MatrixEntity {
        if (rows != matrixEntity.rows || columns != matrixEntity.columns) {
            throw IllegalMatrixSize()
        }
        val result = MutableList(rows) { MutableList(columns) { 0 } }
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                result[i][j] = returnNumber(i, j) - matrixEntity.returnNumber(i, j)
            }
        }
        return MatrixEntity(result)
    }

    override fun multiply(matrixEntity: MatrixEntity): MatrixEntity {
        if (columns != matrixEntity.rows) {
            throw IllegalMatrixSize()
        }
        val result = MutableList(rows) { MutableList(matrixEntity.columns) { 0 } }
        for (i in 0 until rows) {
            for (j in 0 until matrixEntity.columns) {
                for (k in 0 until matrixEntity.rows) {
                    result[i][j] += returnNumber(i, k) * matrixEntity.returnNumber(k, j)
                }
            }
        }
        return MatrixEntity(result)
    }

    override fun showMatrix(): String {
        var str = ""
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                str += "${returnNumber(i,j)} "
            }
            str += "\n"
        }
        return str
    }
}