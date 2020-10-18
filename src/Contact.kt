import kotlin.collections.HashMap

class Contact {
    var name: String = String()

    val numbers: MutableMap<String, NumType> = HashMap()
//        get() = field.toMutableMap()

    constructor(newName: String, newNumber: String, type: NumType) {
        name = newName
        numbers[newNumber] = type
    }

    fun contains(subString: String): Boolean {
        if (name.contains(subString))
            return true
        for (i in numbers)
            if (i.key.contains(subString))
                return true
        return false
    }

    fun addNumber(number: String, type: NumType) {
        if (number.isNotEmpty()) {
            if (numbers.containsKey(number))
                throw IllegalArgumentException("Number already added!")
            else {
                val hasPlus: Int = (number[0] == '+').int
                if (number.substring(hasPlus..number.length).toLongOrNull() == null)
                    throw IllegalArgumentException("Incorrect number format")
                if (number.length > 11 + hasPlus)
                    throw IllegalArgumentException("Nonexistent number")
                numbers.put(number, type)
            }
        } else
            throw IllegalArgumentException("Received empty number!")
    }

    fun removeNumber(number: String): Boolean {
        return numbers.remove(number) != null
    }

    fun editNumber(numberToEdit: String, newNumber: String = String(), newType: NumType? = null) {
        editNumber(numberToEdit, newNumber)
        editNumber(numberToEdit, newType)
    }

    fun editNumber(numberToEdit: String, newNumber: String = String()) {
        if (newNumber.isNotEmpty()) {
            if (numbers.containsKey(newNumber))
                throw IllegalArgumentException("Number already added!")
            else {
                val hasPlus: Int = (newNumber[0] == '+').int
                if (newNumber.substring(hasPlus..newNumber.length).toLongOrNull() == null)
                    throw IllegalArgumentException("Incorrect number format")
                if (newNumber.length > 11 + hasPlus)
                    throw IllegalArgumentException("Nonexistent number")

                val type = numbers.remove(numberToEdit)
                        ?: throw IllegalArgumentException("Replacing nonexistent number!")

                numbers.put(newNumber, type)
            }
        } else
            throw IllegalArgumentException("Received empty number!")
    }

    fun editNumber(numberToEdit: String, newType: NumType? = null) {
        numbers[numberToEdit] = newType ?: throw IllegalArgumentException("Didn't receive type!")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other !is Contact)
            return false
        else {
            if (name != other.name)
                return false
            if (numbers != other.numbers)
                return false
            return true
        }
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun toString(): String {
        var stringRepresentation: String = name + '\n'
        for (i in numbers)
            stringRepresentation += "    " + i.key + ' ' + i.value + '\n'

        return stringRepresentation
    }

    private val Boolean.int
        get() = if (this) 1 else 0
}
