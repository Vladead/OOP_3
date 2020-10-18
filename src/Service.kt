import java.lang.IllegalArgumentException
import kotlin.system.exitProcess

class Service {
    private val phonebook: Phonebook = Phonebook()

    private var currentContact: Contact? = null

    fun add() {
        println("Write name: ")
        val name = readLine()!!
        println("Write number: ")
        var phoneNumber = readLine()!!
        println("Write number type:\n" +
                "1 - Mobile\n" +
                "2 - Home\n" +
                "3 - Work\n")
        var numberType = when (readLine()!!) {
            "1" -> NumType.MOBILE
            "2" -> NumType.HOME
            "3" -> NumType.WORK
            else -> return
        }
        val newContact = Contact(name, phoneNumber, numberType)
        loop@ while (true) {
            println("Do you want to add another number? yes/no")
            when (readLine()!!.toLowerCase()) {
                "yes" -> {
                    println("Write number: ")
                    phoneNumber = readLine()!!
                    println("Write number type:\n" +
                            "1 - Mobile\n" +
                            "2 - Home\n" +
                            "3 - Work\n")
                    numberType = when (readLine()!!) {
                        "1" -> NumType.MOBILE
                        "2" -> NumType.HOME
                        "3" -> NumType.WORK
                        else -> return
                    }
                    try {
                        newContact.addNumber(phoneNumber, numberType)
                    } catch (e: IllegalArgumentException) {
                        println(e.message)
                    }
                }
                "no" -> {
                    break@loop
                }
            }
        }
        phonebook.add(newContact)
    }

    fun remove() {
        val foundContacts = search()
        if (foundContacts != null) {
            for (i in 0..foundContacts.size) {
                println("${i + 1} " + foundContacts[i].toString())
            }
            println("What contact do you want to delete?")
            val index = readLine()?.toIntOrNull()
            if (index != null && foundContacts.size <= index)
                phonebook.remove(foundContacts[index - 1])
            else
                println("Wrong index")
        }
    }

    fun edit() {
        TODO("")
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
