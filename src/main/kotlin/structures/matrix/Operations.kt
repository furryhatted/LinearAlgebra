package structures.matrix

import structures.*
import structures.vector.dot

/**
 *`Matrix` transformation operation
 *
 * Applies given lambda operation to each element of matrix
 * and returns resulting as new instance of [Matrix] class
 *
 * @param operation [Function] to apply
 * @return [Matrix] - transformed result
 * @see Matrix
 */
operator fun <T : Number> Matrix<T>.rem(operation: (T) -> T): Matrix<T> =
    Matrix(this.height, this.width, this.map { operation(it) })

/**
 *`Matrix` addition operation
 *
 * Adds [Matrix] to given
 * and returns resulting as new instance of [Matrix] class
 *
 * @param other [Matrix] to add to given
 * @return [Matrix] - addition result
 * @see Matrix
 */
operator fun <T : Number> Matrix<T>.plus(other: Matrix<T>): Matrix<T> =
    if (this.width != other.width && this.height != other.height) throw IllegalArgumentException("Non-compatible matrix size!")
    else Matrix(this.height, this.width, this.zip(other) { v1, v2 -> v1 + v2 })

/**
 *`Matrix` addition operation
 *
 * Adds given [T] to matrix element-wise
 * and returns resulting as new instance of [Matrix] class
 *
 * @param other [Matrix] to add to given
 * @return [Matrix] - subtraction result
 * @see Matrix
 */
operator fun <T : Number> Matrix<T>.plus(other: T): Matrix<T> =
    Matrix(this.height, this.width, this.map { value -> value + other })

/**
 *`Matrix` subtraction operation
 *
 * Subtracts [Matrix] from given
 * and returns resulting as new instance of [Matrix] class
 *
 * @param other [Matrix] to subtract from given
 * @return [Matrix] - subtraction result
 * @see Matrix
 */
operator fun <T : Number> Matrix<T>.minus(other: Matrix<T>): Matrix<T> =
    if (this.width != other.width && this.height != other.height) throw IllegalArgumentException("Non-compatible matrix size!")
    else Matrix(this.height, this.width, this.zip(other) { v1, v2 -> v1 - v2 })

/**
 *`Matrix` subtraction operation
 *
 * Subtracts given [T] from matrix element-wise
 * and returns resulting as new instance of [Matrix] class
 *
 * @param other [Matrix] to subtract from given
 * @return [Matrix] - subtraction result
 * @see Matrix
 */
operator fun <T : Number> Matrix<T>.minus(other: T): Matrix<T> =
    Matrix(this.height, this.width, this.map { value -> value - other })

/**
 *`Matrix` subtraction operation
 *
 * Subtracts [Matrix] from given
 * and returns resulting as new instance of [Matrix] class
 *
 * @param other [Matrix] to subtract from given
 * @return [Matrix] - subtraction result
 * @see Matrix
 */
operator fun <T : Number> T.minus(other: Matrix<T>): Matrix<T> =
    Matrix(other.height, other.width, other.map { this - it })

/**
 *`Matrix` scaling operation
 *
 * Multiplies [Matrix] by given `T`
 * and returns resulting as new instance of [Matrix] class
 *
 * @param scalar [T] to scale by
 * @return [Matrix] - multiplication result
 * @see Matrix
 */
operator fun <T : Number> Matrix<T>.times(scalar: T): Matrix<T> =
    this.rem { value -> value * scalar }

/**
 *`Matrix` unary structures.minus operation
 *
 * Inverses sign of [Matrix] elements
 * and returns resulting as new instance of [Matrix] class
 *
 * @return [Matrix] - multiplication result
 * @see Matrix
 */
operator fun <T : Number> Matrix<T>.unaryMinus(): Matrix<T> =
    this.rem { value -> -value }

/**
 * `Matrix` transpose operation
 *
 * Flips `Matrix` over its main diagonal and returns result
 * as new instance of [Matrix] class
 *
 * @return [Matrix] - transposed `Matrix`
 * @see Matrix
 */
operator fun <T : Number> Matrix<T>.not(): Matrix<T> =
    Matrix(this.columns)

/**
 * `Matrix` multiplication
 *
 * Multiplies two matrices and returns result
 * as new instance of [Matrix] class
 *
 * @param other [Matrix] to multiply with
 * @return [Matrix] - multiplication result
 * @throws [IllegalArgumentException] if left matrix has different width as right matrix height
 * @see Matrix
 */
operator fun <T : Number> Matrix<T>.times(other: Matrix<T>): Matrix<T> =
    if (this.width != other.height) throw IllegalArgumentException("Non-compatible matrix size!")
    else Matrix(this.rows.map { row -> other.columns.map { column -> row.dot(column) } })

/**
 * `Matrix` multiplication
 *
 * Multiplies matrix with vector and returns result
 * as new instance of [Vector] class
 *
 * @param other [Vector] to multiply with
 * @return [Vector] multiplication result
 * @throws [IllegalArgumentException] if left matrix has different width as right matrix height
 * @see Matrix
 * @see Vector
 */
operator fun <T : Number> Matrix<T>.times(other: Vector<T>): Vector<T> =
    if (this.width != other.size) throw IllegalArgumentException("Non-compatible vector size!")
    else Vector(this.rows.map { row -> row.dot(other) })

/**
 * `Matrix` element-wise multiplication (Hadamard product)
 *
 * Multiplies two matrices and returns result
 * as new instance of [Matrix] class
 *
 * @param other [Matrix] to multiply with
 * @return [Matrix] - multiplication result
 * @throws [IllegalArgumentException] if left matrix has different width as right matrix height
 * @see Matrix
 */
fun <T : Number> Matrix<T>.hadamard(other: Matrix<T>): Matrix<T> =
    if (this.width != other.width && this.height != other.height) throw IllegalArgumentException("Non-compatible matrix size!")
    else Matrix(this.height, this.width, this.zip(other) { v1, v2 -> v1 * v2 })


/**
 *`Matrix` scaling operation
 *
 * Multiplies [Matrix] by given [T]
 * and returns resulting as new instance of [Matrix] class
 *
 * @param matrix [Matrix] to multiply
 * @return [Matrix] - transformed result
 * @see Matrix
 */
operator fun <T : Number> T.times(matrix: Matrix<T>): Matrix<T> = matrix * this
