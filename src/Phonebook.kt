class Phonebook {
    private val contacts: MutableSet<Contact> = HashSet()

    fun add(contact: Contact) {
        contacts.add(contact)
    }

    fun remove(contact: Contact) {
        contacts.remove(contact)
    }

    fun search(subString: String): ArrayList<Contact>? {
        val foundContacts: ArrayList<Contact> = ArrayList()
        for (i in contacts)
            if (i.contains(subString))
                foundContacts.add(i)
        return if (foundContacts.isEmpty())
            null
        else
            foundContacts
    }

    fun getAll(): Set<Contact>? {
        return contacts.toSet()
    }
}