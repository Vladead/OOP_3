class Phonebook {
    private val contacts: MutableSet<Contact> = HashSet()

    operator fun get(str: String): Set<String>? {
        for (i in contacts) {
            TODO("Обписать прохождение по контакту")
        }
        return null
    }

    fun add() {

    }

    fun remove() {

    }
}