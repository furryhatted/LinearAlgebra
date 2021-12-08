package structures

fun <T : Number> Collection<Collection<T>>.asMatrix(): Matrix<T> = Matrix(this)

fun <T : Number> Collection<T>.asVector() = Vector(this)

@Suppress("UNCHECKED_CAST")
@Throws(UnsupportedOperationException::class)
fun <T : Number> List<T>.sum(): T =
    when (this.first()) {
        is Double -> {
            var acc = 0.0
            this.forEach { acc += (it as Double) }
            acc as T
        }
        is Int -> {
            var acc = 0
            this.forEach { acc += (it as Int) }
            acc as T
        }
        is Float -> {
            var acc = 0.0f
            this.forEach { acc += (it as Float) }
            acc as T
        }
        else -> throw UnsupportedOperationException("Operation unsupported for ${this.first()::class.java}")
    }

@Suppress("UNCHECKED_CAST")
@Throws(ArithmeticException::class, UnsupportedOperationException::class)
operator fun <T : Number> T.plus(other: T): T =
    when {
        this is Int && other is Int -> (this + other) as T
        this is Double && other is Double -> (this + other)
            .also { if (!it.isFinite()) throw ArithmeticException("NaN or Infinite result") } as T
        this is Float && other is Float -> (this + other)
            .also { if (!it.isFinite()) throw ArithmeticException("NaN or Infinite result") } as T
        else -> throw UnsupportedOperationException("Operation unsupported for ${this::class.java} and ${other::class.java}")
    }

@Suppress("UNCHECKED_CAST")
@Throws(ArithmeticException::class, UnsupportedOperationException::class)
operator fun <T : Number> T.minus(other: T): T =
    when {
        this is Int && other is Int -> (this - other) as T
        this is Double && other is Double -> (this - other)
            .also { if (!it.isFinite()) throw ArithmeticException("NaN or Infinite result") } as T
        this is Float && other is Float -> (this - other)
            .also { if (!it.isFinite()) throw ArithmeticException("NaN or Infinite result") } as T
        else -> throw UnsupportedOperationException("Operation unsupported for ${this::class.java} and ${other::class.java}")
    }

@Suppress("UNCHECKED_CAST")
@Throws(ArithmeticException::class, UnsupportedOperationException::class)
operator fun <T : Number> T.unaryMinus(): T =
    when (this) {
        is Int -> -this as T
        is Double -> (-this)
            .also { if (!it.isFinite()) throw ArithmeticException("NaN or Infinite result") } as T
        is Float -> (-this)
            .also { if (!it.isFinite()) throw ArithmeticException("NaN or Infinite result") } as T
        else -> throw UnsupportedOperationException("Operation unsupported for ${this::class.java}")
    }


@Suppress("UNCHECKED_CAST")
@Throws(ArithmeticException::class, UnsupportedOperationException::class)
operator fun <T : Number> T.times(other: T): T =
    when {
        this is Int && other is Int -> (this * other) as T
        this is Double && other is Double -> (this * other)
            .also { if (!it.isFinite()) throw ArithmeticException("NaN or Infinite result") } as T
        this is Float && other is Float -> (this * other)
            .also { if (!it.isFinite()) throw ArithmeticException("NaN or Infinite result") } as T
        else -> throw UnsupportedOperationException("Operation unsupported for ${this::class.java} and ${other::class.java}")
    }

@Suppress("UNCHECKED_CAST")
@Throws(ArithmeticException::class, UnsupportedOperationException::class)
operator fun <T : Number> T.div(other: T): T =
    when {
        this is Int && other is Int -> (this / other) as T
        this is Double && other is Double -> (this / other)
            .also { if (!it.isFinite()) throw ArithmeticException("NaN or Infinite result") } as T
        this is Float && other is Float -> (this / other)
            .also { if (!it.isFinite()) throw ArithmeticException("NaN or Infinite result") } as T
        else -> throw UnsupportedOperationException("Operation unsupported for ${this::class.java} and ${other::class.java}")
    }

@Throws(UnsupportedOperationException::class)
fun <T : Number> T.asString(): String =
    when (this) {
        is Double -> this.toBigDecimal().toPlainString()
        is Int -> this.toString()
        is Float -> this.toBigDecimal().toPlainString()
        else -> throw UnsupportedOperationException("Operation unsupported for ${this::class.java}")
    }

fun sqrt(x: Int): Double = kotlin.math.sqrt(x.toDouble())