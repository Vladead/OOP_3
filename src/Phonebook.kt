class Phonebook {
    val contacts: MutableList<Contact> = ArrayList()

    fun add(contact: Contact) {
        contacts.add(contact)
    }

    fun remove(contact: Contact) {
        contacts.remove(contact)
    }

    fun search(subString: String): MutableList<Contact>? {
        val foundContacts: MutableList<Contact> = ArrayList()
        for (i in contacts)
            if (i.contains(subString))
                foundContacts.add(i)
        return if (foundContacts.isEmpty())
            null
        else
            foundContacts
    }
}
