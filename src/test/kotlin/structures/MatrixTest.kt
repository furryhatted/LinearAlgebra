package structures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class MatrixTest {
    private val testMatrix: Matrix<Int> = Matrix(2, 3, 1, 2, 3, 4, 5, 6)
    private val scaledMatrix: Matrix<Int> = Matrix(2, 3, 2, 4, 6, 8, 10, 12)

    @Test
    fun shouldThrowOnSizeDifference() {
        val randomList = List(16) { Random.nextInt() }
        assertThrows(
            IllegalArgumentException::class.java,
            { Matrix(2, 2, randomList) },
            "Expected to throw if elements size not equals matrix size"
        )
    }

    @Test
    fun shouldNotBeEqualsByIndices() {
        val copyMatrix = Matrix(testMatrix.rows)
        assertEquals(false, testMatrix == scaledMatrix)
        assertEquals(true, testMatrix == copyMatrix)
    }

    @Test
    fun shouldReturnRow() {
        assertEquals(listOf(4, 5, 6), testMatrix.rows[1].toList())
    }

    @Test
    fun shouldReturnColumn() {
        assertEquals(listOf(2, 5), testMatrix.columns[1].toList())

    }

    @Test
    fun shouldReturnByIndex() {
        assertEquals(2, testMatrix[1])
    }

    @Test
    fun shouldReturnByPair() {
        assertEquals(5, testMatrix[1, 1])
    }
}