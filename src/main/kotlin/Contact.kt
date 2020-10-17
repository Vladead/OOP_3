import kotlin.collections.HashMap
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck

class Contact {
    var name: String = String()
    private val numbers: MutableMap<String, NumType> = HashMap()

    constructor(newName: String, newNumber: String, type: NumType) {
        name = newName
        numbers.put(newNumber, type)
    }

    fun get(str: String) : Map<String, NumType> {
        return numbers.toMap()
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