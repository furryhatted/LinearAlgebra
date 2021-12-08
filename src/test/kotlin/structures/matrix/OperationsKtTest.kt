package structures.matrix

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import structures.Matrix

internal class OperationsKtTest {
    private val matrix: Matrix<Int> = Matrix(2, 3, 1, 2, 3, 4, 5, 6)
    private val scaled: Matrix<Int> = Matrix(2, 3, 2, 4, 6, 8, 10, 12)
    private val transposed: Matrix<Int> = Matrix(3, 2, 1, 4, 2, 5, 3, 6)
    private val mtMultiplication: Matrix<Int> = Matrix(2, 2, 14, 32, 32, 77)
    private val tmMultiplication: Matrix<Int> = Matrix(3, 3, 17, 22, 27, 22, 29, 36, 27, 36, 45)

    @Test
    fun shouldProduceAdditionResult() {
        Assertions.assertEquals(scaled, matrix + matrix)
    }

    @Test
    fun shouldThrowOnAdditionToDifferentShape() {
        Assertions.assertThrows(IllegalArgumentException::class.java) { matrix + transposed }
    }

    @Test
    fun shouldProduceScalarMultiplicationResult() {
        Assertions.assertEquals(scaled, matrix * 2)
    }

    @Test
    fun shouldProduceTransposeResult() {
        Assertions.assertEquals(transposed, !matrix)
    }

    @Test
    fun shouldProduceMultiplicationResult() {
        Assertions.assertEquals(mtMultiplication, matrix * transposed)
        Assertions.assertEquals(tmMultiplication, transposed * matrix)
    }

    @Test
    fun shouldThrowOnMultiplication() {
        Assertions.assertThrows(IllegalArgumentException::class.java) { matrix * matrix }
    }

    @Test
    fun rem() {
    }

    @Test
    fun plus() {
    }

    @Test
    fun testPlus() {
    }

    @Test
    fun minus() {
    }

    @Test
    fun testMinus() {
    }

    @Test
    fun testMinus1() {
    }

    @Test
    fun times() {
    }

    @Test
    operator fun unaryMinus() {
    }

    @Test
    operator fun not() {
    }

    @Test
    fun testTimes() {
    }

    @Test
    fun testTimes1() {
    }

    @Test
    fun hadamard() {
    }

    @Test
    fun testTimes2() {
    }
}