package structures

/**
 * Skeletal implementation of [Structure] interface
 * Provides basic element access methods
 * @param T [Number]
 * @property elements [List] of [T] used as backing filed for structure elements
 * @property instanceName [String] holds class simple name with hash id
 */
abstract class AbstractStructure<T : Number>(
    private val elements: List<T>
) : Structure<T>, AbstractCollection<T>() {

    /**
     * Returns [Int] element-wise size of a structure
     */
    override val size: Int
        get() = elements.size

    /**
     * Returns [T] element form structure with given index
     * @param index [Int] index of element
     */
    override operator fun get(index: Int): T = elements[index]

    /**
     * Sets value for element with given index
     * @param index [Int] index of element
     * @param value [T] value to set
     */
    override operator fun set(index: Int, value: T) {
        (elements as MutableList)[index] = value
    }

    /**
     * Nothing fancy - just [elements] iterator
     * @return [Iterator] value
     */
    override fun iterator(): Iterator<T> = elements.iterator()


    /**
     * Element-wise addition operation
     * @param other [Structure] to add
     * @return [Structure] this instance
     */
    override fun add(other: Structure<T>): Structure<T> {
        if (this.size != other.size) throw IllegalArgumentException("Non-compatible structure size!")
        this.indices.map { this[it] += other[it] }
        return this
    }

    /**
     * Element-wise addition operation
     * @param value [T] to add
     * @return [Structure] this instance
     */
    override fun add(value: T): Structure<T> {
        this.indices.map { this[it] += value }
        return this
    }

    /**
     * Element-wise subtraction operation
     * @param other [Structure] to subtract
     * @return [Structure] this instance
     */
    override fun subtract(other: Structure<T>): Structure<T> {
        if (this.size != other.size) throw IllegalArgumentException("Non-compatible structure size!")
        this.indices.map { this[it] -= other[it] }
        return this
    }

    /**
     * Element-wise subtraction operation
     * @param value [T] to subtract
     * @return [Structure] this instance
     */
    override fun subtract(value: T): Structure<T> {
        this.indices.map { this[it] -= value }
        return this
    }

    /**
     * Element-wise multiplication operation
     * @param other [Structure] to multiply
     * @return [Structure] this instance
     */
    override fun multiply(other: Structure<T>): Structure<T> {
        if (this.size != other.size) throw IllegalArgumentException("Non-compatible structure size!")
        this.indices.map { this[it] *= other[it] }
        return this
    }

    /**
     * Element-wise multiplication operation
     * @param value [T] to multiply
     * @return [Structure] this instance
     */
    override fun multiply(value: T): Structure<T> {
        this.indices.map { this[it] *= value }
        return this
    }

    /**
     * Element-wise division operation
     * @param other [Structure] to divide
     * @return [Structure] this instance
     */
    override fun divide(other: Structure<T>): Structure<T> {
        if (this.size != other.size) throw IllegalArgumentException("Non-compatible structure size!")
        this.indices.map { this[it] /= other[it] }
        return this
    }

    /**
     * Element-wise division operation
     * @param value [T] to divide
     * @return [Structure] this instance
     */
    override fun divide(value: T): Structure<T> {
        this.indices.map { this[it] /= value }
        return this
    }

    /**
     * Element-wise transformation operation
     * @param operation [Function] to apply
     * @return [Structure] this instance
     */
    override fun transform(operation: (T) -> T): Structure<T> {
        this.indices.map { this[it] = operation(this[it]) }
        return this
    }

    /**
     * Element-wise comparison operation
     * @param other [Any] to compare
     * @return [Boolean] if given is [AbstractStructure] and element-wise are equals
     */
    override fun equals(other: Any?): Boolean =
        if (other !is AbstractStructure<*>) false
        else this.zip(other).all { it.first == it.second }

    override fun hashCode(): Int {
        var result = size
        result = 31 * result + elements.hashCode()
        return result
    }

    val instanceName: String = "${this::class.java.simpleName}@${Integer.toHexString(this.hashCode())}"
}