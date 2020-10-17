import kotlin.collections.HashMap
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck

class Contact {
    var name: String = String()

    private val numbers: MutableMap<String, NumType> = HashMap()

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
        TODO("Влад = потом")
        return super.equals(other)
    }

    override fun hashCode(): Int {
        TODO("Влад = потом")
        return super.hashCode()
    }

    override fun toString(): String {
        TODO("Влад = потом")
        return super.toString()
    }
}