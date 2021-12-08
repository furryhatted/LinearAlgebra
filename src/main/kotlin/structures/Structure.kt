package structures

interface Structure<T> : Collection<T> {
    operator fun get(index: Int): T

    operator fun set(index: Int, value: T)

    fun add(other: Structure<T>): Structure<T>

    fun add(value: T): Structure<T>

    fun subtract(other: Structure<T>): Structure<T>

    fun subtract(value: T): Structure<T>

    fun multiply(other: Structure<T>): Structure<T>

    fun multiply(value: T): Structure<T>

    fun divide(other: Structure<T>): Structure<T>

    fun divide(value: T): Structure<T>

    fun transform(operation: (T) -> T): Structure<T>
}