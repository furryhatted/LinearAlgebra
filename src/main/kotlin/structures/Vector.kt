package structures

class Vector<T : Number>(
    elements: List<T>
) : AbstractStructure<T>(elements) {

    constructor(collection: Collection<T>) :
            this(MutableList(collection.size) { index -> collection.elementAt(index) })

    constructor (vararg elements: T) :
            this(MutableList(elements.size) { index -> elements[index] })

    constructor(size: Int, init: (Int) -> T) :
            this(MutableList(size, init))

    override fun toString(): String = this
        .joinToString(", ", "|", "|")


    override fun equals(other: Any?): Boolean =
        if (other is Vector<*> && this.size == other.size)
            super.equals(other) else false

    /**
     * Provides basic hash
     * @return [Int] hash value
     */
    override fun hashCode(): Int {
        var result = size
        result = 31 * result + super.hashCode()
        return result
    }
}