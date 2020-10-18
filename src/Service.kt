class Service {
    private val phonebook: Phonebook = Phonebook()

    private var currentContact: Contact? = null

    fun add(newName: String, newNumber: String, type: NumType) {
        TODO("Влад допишет")
    }

    fun remove() {
        TODO("Влад допишет")
    }

    fun edit() {
        TODO("Влад допишет")
    }

    fun show() {
        val foundContacts = search()
        if (foundContacts == null)
            println("Nothing was found!")
        else {
            for (i in foundContacts.indices)
                println("${i + 1}: " + foundContacts[i].toString())
        }
    }

    fun showAll() {
        val contacts = phonebook.contacts
        for (i in contacts.indices)
            println("${i + 1}: " + contacts[i].toString())
    }

    private fun search(): MutableList<Contact>? {
        println("What are we looking for?\n")
        val subStr = readLine() ?: throw IllegalArgumentException("Nothing was entered!")
        return phonebook.search(subStr)
    }
}
