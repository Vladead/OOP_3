import kotlin.collections.HashMap
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck

class Contact {
    var name: String = String()

    private val numbers: MutableMap<String, NumType> = HashMap()
        get() = field.toMutableMap()

    constructor(newName: String, newNumber: String, type: NumType) {
        name = newName
        numbers[newNumber] = type
    }

    fun contains(subString: String) : Boolean {
        if (name.contains(subString))
            return true
        for (i in numbers)
            if (i.key.contains(subString))
                return true
        return false
    }

    fun addNumber(number: String, type: NumType) {
        TODO("Влад = потом")
    }

    fun removeNumber(number: String) {
        TODO("Влад = потом")
    }

    fun editNumber(numberToEdit: String, newNumber: String? = null, newType: NumType? = null) {
        TODO("Влад = потом")
    }

    fun editNumber(numberToEdit: String, newNumber: String? = null) {
        TODO("Влад = потом")
    }

    fun editNumber(numberToEdit: String, newType: NumType? = null) {
        TODO("Влад = потом")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other !is Contact)
            return false
        else
        {
            if (name !=  other.name)
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
            stringRepresentation += i.key + ' ' + i.value + '\n'
        
        return stringRepresentation
    }
}