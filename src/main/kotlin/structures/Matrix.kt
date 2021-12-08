package structures

/**
 *`Matrix` implementation
 *
 * Extends [AbstractStructure] class
 * Implements methods for by-row and by-column access to elements
 * @param T [Number]
 * @property height [Int] value of matrix rows
 * @property width [Int] value of matrix columns
 * @property elements [List] matrix elements holder
 * @property rows provides access to [List] of [Vector] of elements ordered in rows
 * @property columns provides access to [List] of [Vector] of elements ordered in columns
 * @property size returns total elements count
 * @constructor creates [Matrix] from [List] of [T]
 */
class Matrix<T : Number>(
    val height: Int,
    val width: Int,
    elements: List<T>,
) : AbstractStructure<T>(elements) {
    /**
     * Creates instance from [T] vararg
     */
    constructor(height: Int, width: Int, vararg elements: T) : this(
        height,
        width,
        elements.toMutableList()
    )

    /**
     * Creates instance from flat [Collection] of [T]
     */
    constructor(height: Int, width: Int, collection: Collection<T>) : this(
        height,
        width,
        collection.toMutableList()
    )

    /**
     * Creates instance from 2D [Collection] of [T]
     */
    constructor(collection: Collection<Collection<T>>) : this(
        collection.size, collection.first().size, collection.flatten()
    )

    /**
     * Creates instance with initialization [Function] function
     */
    constructor(height: Int, width: Int, init: (Int) -> T) : this(
        height, width, MutableList(height * width, init)
    )

    /**
     * Removes all excessive data from given list
     * and checks element count
     */
    init {
        if (elements.size != height * width)
            throw IllegalArgumentException("Cant build Matrix[${height * width}] from Collection[${elements.size}]")
    }

    /**
     * Element indexes arranged by rows
     * Causes small memory overhead but provides better performance overall
     */
    private val byRow: List<List<Int>> = elements.indices.chunked(width)

    /**
     * Element indexes arranged by columns
     * Causes small memory overhead but provides better performance overall
     */
    private val byColumn: List<List<Int>> = elements.indices.groupBy { it % width }.map { it.value }

    /**
     * Returns element by 2D coordinates
     * @param row [Int] value of row
     * @param column [Int] value of column
     */
    operator fun get(row: Int, column: Int): T = this[byRow[row][column]]

    /**
     * Returns row by index
     * @param index [Int] row index
     * @return [Vector] value of row
     */
    fun getRow(index: Int): Vector<T> = Vector(byRow[index].map { this[it] })

    /**
     * Returns collection of rows
     * @return [List] of [Vector] value
     */
    val rows: List<Vector<T>>
        get() = byRow.indices.map { getRow(it) }

    /**
     * Returns column by index
     * @param index [Int] column index
     * @return [Vector] value of column
     */
    fun getColumn(index: Int): Vector<T> = Vector(byColumn[index].map { this[it] })

    /**
     * Returns collection of columns
     * @return [List] of [Vector]
     */
    val columns: List<Vector<T>>
        get() = byColumn.indices.map { getColumn(it) }

    /**
     * Checks equality by dimensions
     * @param other nullable [Any] value to compare against
     * @return [Boolean] value. True if given object is [Matrix], has same [height] and [width] and elements are equal
     */
    override fun equals(other: Any?): Boolean =
        if (other is Matrix<*> && this.width == other.width && this.height == other.height)
            super.equals(other) else false

    /**
     * Provides basic hash
     * @return [Int] hash value
     */
    override fun hashCode(): Int {
        var result = height
        result = 31 * result + width
        result = 31 * result + super.hashCode()
        return result
    }

    /**
     * Joins elements arranged in rows
     * @return [String] value
     */
    override fun toString(): String = rows.joinToString(";", "|", "|")
}

