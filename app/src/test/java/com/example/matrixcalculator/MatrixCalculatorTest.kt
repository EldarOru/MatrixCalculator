package com.example.matrixcalculator

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*


class MatrixCalculatorTest {

    @Test
    fun `sum 3x3`() {
        val firstMatrix =
            mutableListOf(
                mutableListOf(1, 2, 3),
                mutableListOf(4, 5, 6),
                mutableListOf(7, 8, 9)
            )
        val secondMatrix =
            mutableListOf(
                mutableListOf(1, 2, 3),
                mutableListOf(4, 5, 6),
                mutableListOf(7, 8, 9)
            )

        val sumMatrixCommand = SumCommand(MatrixEntity(firstMatrix), MatrixEntity(secondMatrix))

        val matrixCalculator = MatrixCalculator.Base(stack = Stack())

        val result = matrixCalculator.executeCommand(sumMatrixCommand)

        val expected = ResultState.SuccessState(
            MatrixEntity(
                mutableListOf(
                    mutableListOf(2, 4, 6),
                    mutableListOf(8, 10, 12),
                    mutableListOf(14, 16, 18)
                )
            )
        )

        assertEquals(expected, result)
    }

    @Test
    fun `sum 3x2`() {
        val firstMatrix =
            mutableListOf(
                mutableListOf(1, 2),
                mutableListOf(4, 5),
                mutableListOf(7, 8)
            )
        val secondMatrix =
            mutableListOf(
                mutableListOf(5, 3),
                mutableListOf(8, 8),
                mutableListOf(1, 2)
            )

        val sumMatrixCommand = SumCommand(MatrixEntity(firstMatrix), MatrixEntity(secondMatrix))

        val matrixCalculator = MatrixCalculator.Base(stack = Stack())

        val result = matrixCalculator.executeCommand(sumMatrixCommand)

        val expected = ResultState.SuccessState(
            MatrixEntity(
                mutableListOf(
                    mutableListOf(6, 5),
                    mutableListOf(12, 13),
                    mutableListOf(8, 10)
                )
            )
        )

        assertEquals(expected, result)
    }

    @Test
    fun `sum 3x1`() {
        val firstMatrix =
            mutableListOf(
                mutableListOf(1),
                mutableListOf(3),
                mutableListOf(5)
            )
        val secondMatrix =
            mutableListOf(
                mutableListOf(5),
                mutableListOf(8),
                mutableListOf(1)
            )

        val sumMatrixCommand = SumCommand(MatrixEntity(firstMatrix), MatrixEntity(secondMatrix))

        val matrixCalculator = MatrixCalculator.Base(stack = Stack())

        val result = matrixCalculator.executeCommand(sumMatrixCommand)

        val expected = ResultState.SuccessState(
            MatrixEntity(
                mutableListOf(
                    mutableListOf(6),
                    mutableListOf(11),
                    mutableListOf(6)
                )
            )
        )

        assertEquals(expected, result)
    }

    @Test
    fun `sum 2x4`() {
        val firstMatrix =
            mutableListOf(
                mutableListOf(1, 2, 3, 8),
                mutableListOf(4, 6, 6, 20)
            )
        val secondMatrix =
            mutableListOf(
                mutableListOf(5, 6, 10, 11),
                mutableListOf(4, 5, 6, -3)
            )

        val sumMatrixCommand = SumCommand(MatrixEntity(firstMatrix), MatrixEntity(secondMatrix))

        val matrixCalculator = MatrixCalculator.Base(stack = Stack())

        val result = matrixCalculator.executeCommand(sumMatrixCommand)

        val expected = ResultState.SuccessState(
            MatrixEntity(
                mutableListOf(
                    mutableListOf(6, 8, 13, 19),
                    mutableListOf(8, 11, 12, 17)
                )
            )
        )

        assertEquals(expected, result)
    }

    @Test
    fun `sum fail`() {
        val firstMatrix =
            mutableListOf(
                mutableListOf(1, 2),
                mutableListOf(4, 5)
            )
        val secondMatrix =
            mutableListOf(
                mutableListOf(5, 3),
                mutableListOf(8, 8),
                mutableListOf(1, 2)
            )

        val sumMatrixCommand = SumCommand(MatrixEntity(firstMatrix), MatrixEntity(secondMatrix))

        val matrixCalculator = MatrixCalculator.Base(stack = Stack())

        val result = matrixCalculator.executeCommand(sumMatrixCommand)

        val expected = ResultState.ErrorState(
            "err"
        )

        assertEquals(expected, result)
    }

    @Test
    fun `diff 3x3`() {
        val firstMatrix =
            mutableListOf(
                mutableListOf(1, 2, 3),
                mutableListOf(4, 6, 6),
                mutableListOf(7, 8, 9)
            )
        val secondMatrix =
            mutableListOf(
                mutableListOf(1, 2, 3),
                mutableListOf(4, 5, 6),
                mutableListOf(7, 8, 9)
            )

        val diffMatrixCommand = DiffCommand(MatrixEntity(firstMatrix), MatrixEntity(secondMatrix))

        val matrixCalculator = MatrixCalculator.Base(stack = Stack())

        val result = matrixCalculator.executeCommand(diffMatrixCommand)

        val expected = ResultState.SuccessState(
            MatrixEntity(
                mutableListOf(
                    mutableListOf(0, 0, 0),
                    mutableListOf(0, 1, 0),
                    mutableListOf(0, 0, 0)
                )
            )
        )

        assertEquals(expected, result)
    }

    @Test
    fun `diff 2x4`() {
        val firstMatrix =
            mutableListOf(
                mutableListOf(1, 2, 3, 8),
                mutableListOf(4, 6, 6, 20)
            )
        val secondMatrix =
            mutableListOf(
                mutableListOf(5, 6, 10, 11),
                mutableListOf(4, 5, 6, -3)
            )

        val diffMatrixCommand = DiffCommand(MatrixEntity(firstMatrix), MatrixEntity(secondMatrix))

        val matrixCalculator = MatrixCalculator.Base(stack = Stack())

        val result = matrixCalculator.executeCommand(diffMatrixCommand)

        val expected = ResultState.SuccessState(
            MatrixEntity(
                mutableListOf(
                    mutableListOf(-4, -4, -7, -3),
                    mutableListOf(0, 1, 0, 23)
                )
            )
        )

        assertEquals(expected, result)
    }


    @Test
    fun `diff 1x2`() {
        val firstMatrix =
            mutableListOf(
                mutableListOf(1, 2)
            )
        val secondMatrix =
            mutableListOf(
                mutableListOf(5, 6)
            )

        val diffMatrixCommand = DiffCommand(MatrixEntity(firstMatrix), MatrixEntity(secondMatrix))

        val matrixCalculator = MatrixCalculator.Base(stack = Stack())

        val result = matrixCalculator.executeCommand(diffMatrixCommand)

        val expected = ResultState.SuccessState(
            MatrixEntity(
                mutableListOf(
                    mutableListOf(-4, -4,)
                )
            )
        )

        assertEquals(expected, result)
    }

    @Test
    fun `diff fail`() {
        val firstMatrix =
            mutableListOf(
                mutableListOf(1, 2, 3, 8),
                mutableListOf(4, 6, 6, 20)
            )
        val secondMatrix =
            mutableListOf(
                mutableListOf(5, 6, 10),
                mutableListOf(4, 5, 6)
            )

        val diffMatrixCommand = DiffCommand(MatrixEntity(firstMatrix), MatrixEntity(secondMatrix))

        val matrixCalculator = MatrixCalculator.Base(stack = Stack())

        val result = matrixCalculator.executeCommand(diffMatrixCommand)

        val expected = ResultState.ErrorState("err")

        assertEquals(expected, result)
    }

    @Test
    fun `multiply 1x2 and 2x1`() {
        val firstMatrix =
            mutableListOf(
                mutableListOf(1, 2)
            )
        val secondMatrix =
            mutableListOf(
                mutableListOf(3),
                mutableListOf(2)
            )

        val multiplyMatrixCommand =
            MultiplyCommand(MatrixEntity(firstMatrix), MatrixEntity(secondMatrix))

        val matrixCalculator = MatrixCalculator.Base(stack = Stack())

        val result = matrixCalculator.executeCommand(multiplyMatrixCommand)

        val expected = ResultState.SuccessState(
            MatrixEntity(
                mutableListOf(
                    mutableListOf(7)
                )
            )
        )

        assertEquals(expected, result)
    }

    @Test
    fun `multiply 2x2 and 2x2`() {
        val firstMatrix =
            mutableListOf(
                mutableListOf(1, 2),
                mutableListOf(5, 6)
            )
        val secondMatrix =
            mutableListOf(
                mutableListOf(3, 4),
                mutableListOf(2, 1)
            )

        val multiplyMatrixCommand =
            MultiplyCommand(MatrixEntity(firstMatrix), MatrixEntity(secondMatrix))

        val matrixCalculator = MatrixCalculator.Base(stack = Stack())

        val result = matrixCalculator.executeCommand(multiplyMatrixCommand)

        val expected = ResultState.SuccessState(
            MatrixEntity(
                mutableListOf(
                    mutableListOf(7, 6),
                    mutableListOf(27, 26)
                )
            )
        )

        assertEquals(expected, result)
    }

    @Test
    fun `multiply fail`() {
        val firstMatrix =
            mutableListOf(
                mutableListOf(1, 2),
                mutableListOf(5, 6)
            )
        val secondMatrix =
            mutableListOf(
                mutableListOf(3, 4),
                mutableListOf(2, 1),
                mutableListOf(2, 1)
            )

        val multiplyMatrixCommand =
            MultiplyCommand(MatrixEntity(firstMatrix), MatrixEntity(secondMatrix))

        val matrixCalculator = MatrixCalculator.Base(stack = Stack())

        val result = matrixCalculator.executeCommand(multiplyMatrixCommand)

        val expected = ResultState.ErrorState("err")

        assertEquals(expected, result)
    }

}