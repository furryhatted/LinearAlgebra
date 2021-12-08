package structures.vector

import structures.*


/**
 *`Vector` transformation operation
 *
 * Applies given lambda operation to each element of vector
 * and returns resulting as new instance of [Vector] class
 *
 * @param operation [Function] to apply
 * @return [Vector] - transformed result
 * @see Vector
 */
operator fun <T : Number> Vector<T>.rem(operation: (T) -> T): Vector<T> =
    Vector(this.map { operation(it) })

/**
 *`Vector` addition operation
 *
 * Adds [Vector] to given
 * and returns resulting as new instance of [Vector] class
 *
 * @param other [Vector] to add to given
 * @return [Vector] - addition result
 * @see Vector
 */

operator fun <T : Number> Vector<T>.plus(other: Vector<T>): Vector<T> =
    if (other.size != this.size) throw IllegalArgumentException("Non-compatible vector size!")
    else Vector(this.zip(other) { value1, value2 -> value1 + value2 })

/**
 *`Vector` shift operation
 *
 * Adds given [T] to vector element-wise
 * and returns resulting as new instance of [Vector] class
 *
 * @param other [Vector] to add to given
 * @return [Vector] - subtraction result
 * @see Vector
 */
@Suppress("UNCHECKED_CAST")
operator fun <T : Number> Vector<T>.plus(other: T): Vector<T> =
    this.rem { value -> value + other }

/**
 *`Vector` subtraction operation
 *
 * Subtracts [Vector] from given
 * and returns resulting as new instance of [Vector] class
 *
 * @param other [Vector] to subtract from given
 * @return [Vector] - subtraction result
 * @see Vector
 */
operator fun <T : Number> Vector<T>.minus(other: Vector<T>): Vector<T> =
    if (other.size != this.size) throw IllegalArgumentException("Non-compatible vector size!")
    else Vector(this.zip(other) { value1, value2 -> value1 - value2 })

/**
 *`Vector` shift operation
 *
 * Subtracts given [T] from vector element-wise
 * and returns resulting as new instance of [Vector] class
 *
 * @param other [Vector] to add to given
 * @return [Vector] - subtraction result
 * @see Vector
 */
operator fun <T : Number> Vector<T>.minus(other: T): Vector<T> =
    this.rem { it - other }

/**
 *`Vector` unary structures.minus operation
 *
 * Inverses sign of [Matrix] elements
 * and returns resulting as new instance of [Matrix] class
 *
 * @return [Matrix] - multiplication result
 * @see Matrix
 */
operator fun <T : Number> Vector<T>.unaryMinus(): Vector<T> =
    this.rem { value -> -value }

/**
 * `Vector` scaling operation
 *
 * Multiplies [Vector] by given `T`
 * and returns resulting as new instance of [Vector] class
 *
 * @param scalar [T] to multiply with
 * @return [Vector] - multiplication result
 * @see Vector
 */
operator fun <T : Number> Vector<T>.times(scalar: T): Vector<T> =
    this.rem { value -> value * scalar }

/**
 * `Vector` multiplication
 *
 * Multiplies vector with matrix and returns result
 * as new instance of [Vector] class
 *
 * @param other [Matrix] to multiply with
 * @return [Vector] - multiplication result
 * @throws [IllegalArgumentException] if left matrix has different width as right matrix height
 * @see Matrix
 * @see Vector
 */
operator fun <T : Number> Vector<T>.times(other: Matrix<T>): Vector<T> =
    if (this.size != other.height) throw IllegalArgumentException("Non-compatible matrix size!")
    else Vector(other.columns.map { column -> this.dot(column) })

/**
 * `Vector` dot operation
 *
 * Multiplies vector with vector element-wise
 * and returns [T] structures.sum as a result
 *
 * @param other [Vector] to multiply with
 * @return [T] resulting dot product
 * @throws [IllegalArgumentException] if vectors have different sizes
 * @see Vector
 */
fun <T : Number> Vector<T>.dot(other: Vector<T>): T =
    if (this.size != other.size) throw IllegalArgumentException("Non-compatible vector size!")
    else this.zip(other) { v1: T, v2: T -> v1 * v2 }.sum()

/**
 * `Vector` multiplication
 *
 * Multiplies vector with vector and returns result
 * as new instance of [Matrix] class
 *
 * @param other [Vector] to multiply with
 * @return [Matrix] multiplication result
 * @see Vector
 */
operator fun <T : Number> Vector<T>.times(other: Vector<T>): Matrix<T> =
    Matrix(this.map { v1 -> other.map { v2 -> v1 * v2 } })

/**
 * `Vector` element-wise multiplication (Hadamard operation)
 *
 * Multiplies vector with vector and returns result
 * as new instance of [Vector] class
 *
 * @param other [Vector] to multiply with
 * @return [Vector] multiplication result
 * @throws [IllegalArgumentException] if vectors have different sizes
 * @see Vector
 */
fun <T : Number> Vector<T>.hadamard(other: Vector<T>): Vector<T> =
    if (this.size != other.size) throw IllegalArgumentException("Non-compatible vector size!")
    else this.zip(other) { value1, value2 -> value1 * value2 }.asVector()

/**
 *`Vector` shift operation
 *
 * Adds [T] to given `Vector`
 * and returns resulting as new instance of [Vector] class
 *
 * @param other [Vector] to shift
 * @return [Vector] - transformed result
 * @see Vector
 */
operator fun <T : Number> T.plus(other: Vector<T>): Vector<T> = other + this

/**
 *`Vector` shift operation
 *
 * Subtracts [T] from given `Vector`
 * and returns resulting as new instance of [Vector] class
 *
 * @param other [Vector] to shift
 * @return [Vector] - transformed result
 * @see Vector
 */
operator fun <T : Number> T.minus(other: Vector<T>): Vector<T> =
    other.rem { this - it }

/**
 *`Vector` scaling operation
 *
 * Multiplies given `Vector` by [T]
 * and returns resulting as new instance of [Vector] class
 *
 * @param other [Vector] to scale
 * @return [Vector] result
 * @see Vector
 */
operator fun <T : Number> T.times(other: Vector<T>): Vector<T> =
    other.rem { this * it }

/**
 *`Vector` scaling operation
 *
 * Divides given `Vector` by [T]
 * and returns resulting as new instance of [Vector] class
 *
 * @param other [Vector] to scale
 * @return [Vector] result
 * @see Vector
 */
operator fun <T : Number> T.div(other: Vector<T>): Vector<T> =
    other.rem { this / it }
