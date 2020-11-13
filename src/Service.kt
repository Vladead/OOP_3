class Service {
    private val phonebook: Phonebook = Phonebook()

    private fun askName(): String {
        println("Write name: ")
        return readLine()!!
    }

    private fun askNumber(): String {
        println("Write number: ")
        return readLine()!!
    }

    private fun askType(): NumType {
        println("Write number type:\n" +
                "1 - Mobile\n" +
                "2 - Home\n" +
                "3 - Work")
        loop@ while (true) {
            return when (readLine()!!) {
                "1" -> NumType.MOBILE
                "2" -> NumType.HOME
                "3" -> NumType.WORK
                else -> continue@loop
            }
        }
    }

    private fun add() {
        val name = askName()
        var phoneNumber = askNumber()
        var numberType = askType()
        val newContact = Contact(name, phoneNumber, numberType)
        loop@ while (true) {
            println("Do you want to add another number? yes/no")
            when (readLine()!!.toLowerCase()) {
                "yes" -> {
                    phoneNumber = askNumber()
                    numberType = askType()
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

    private fun remove() {
        val foundContacts = search()
        if (foundContacts != null) {
            for (i in foundContacts.indices) {
                println("${i + 1}: " + foundContacts[i].toString())
            }
            println("What contact do you want to delete?")
            val index = readLine()?.toIntOrNull()
            if (index != null && foundContacts.size >= index)
                phonebook.remove(foundContacts[index - 1])
            else
                println("Wrong index")
        }
    }

    private fun edit() {
        val found = search()
        if (found == null) {
            println("Nothing found")
            return
        } else {
            for (i in found.indices)
                println("${i + 1}: " + found[i].toString())
            println("Which one to edit? 0 to exit:")
            val contact = when (val i = readLine()?.toIntOrNull()!!) {
                0 -> null
                !in 1..found.size -> {
                    println("Addressing nothing!")
                    null
                }
                in 1..found.size -> found[i - 1]
                else -> {
                    println("Not a number!")
                    null
                }
            }
            if (contact != null) {
                while (true) {
                    println(contact.toString())
                    println("What to do? (Add) or (remove) number, (edit name), (edit) number, " +
                            "(edit type) of number, (edit both) or (quit)?")
                    when (readLine()?.toLowerCase()) {
                        "add" -> {
                            val newNum = askNumber()
                            val newType = askType()
                            try {
                                contact.addNumber(newNum, newType)
                                println("Added successfully!")
                            } catch (e: Exception) {
                                println(e.message)
                            }
                        }
                        "edit name" -> {
                            contact.name = askName()
                        }
                        "edit type" -> {
                            val newType = askType()
                            println("Of which one? (1, 2, ...)")
                            var numNum: Int? = null
                            while (numNum !in 1..contact.numbers.size) {
                                numNum = readLine()?.toInt()
                            }
                            contact.editNumber(contact.numbers.toList()[numNum!! - 1].first, newType)
                        }
                        "edit both" -> {
                            val newType = askType()
                            val newNum = askNumber()
                            println("Which one? (1, 2, ...)")
                            var numNum: Int? = null
                            while (numNum !in 1..contact.numbers.size) {
                                numNum = readLine()?.toInt()
                            }
                            try {
                                contact.editNumber(contact.numbers.toList()[numNum!! - 1].first, newNum, newType)
                            } catch (e: Exception) {
                                println(e.message)
                            }
                        }
                        "edit" -> {
                            val newNum = askNumber()
                            println("Which one? (1, 2, ...)")
                            var numNum: Int? = null
                            while (numNum !in 1..contact.numbers.size) {
                                numNum = readLine()?.toInt()
                            }
                            try {
                                contact.editNumber(contact.numbers.toList()[numNum!! - 1].first, newNum)
                            } catch (e: Exception) {
                                println(e.message)
                            }
                        }
                        "remove" -> {
                            println("Which one? (1, 2, ...)")
                            var numNum: Int? = null
                            while (numNum !in 1..contact.numbers.size) {
                                numNum = readLine()?.toInt()
                            }
                            try {
                                contact.removeNumber(contact.numbers.toList()[numNum!! - 1].first)
                            } catch (e: Exception) {
                                println(e.message)
                            }
                        }
                        "quit" -> {
                            return
                        }
                        else -> {
                            println("Something's wrong\n" +
                                    "Get it right\n" +
                                    "No mistake this time")
                        }
                    }
                }
            } else {
                println("Ending the operation...")
                return
            }
        }
    }

    private fun show() {
        val foundContacts = search()
        if (foundContacts == null)
            println("Nothing was found!")
        else {
            for (i in foundContacts.indices)
                println("${i + 1}: " + foundContacts[i].toString())
        }
    }

    private fun showAll() {
        val contacts = phonebook.getContacts()
        for (i in contacts.indices)
            println("${i + 1}: " + contacts[i].toString())
    }

    private fun search(): MutableList<Contact>? {
        println("What are we looking for?")
        val subStr = readLine() ?: throw IllegalArgumentException("Nothing was entered!")
        return phonebook.search(subStr)
    }

    fun begin() {
        loop@ while (true) {
            println("What do you want?\n" +
                    "1 - Add contact\n" +
                    "2 - Remove contact\n" +
                    "3 - Edit contact\n" +
                    "4 - Show contact\n" +
                    "5 - Show all contacts\n" +
                    "6 - Exit")
            when (readLine()) {
                "1" -> add()
                "2" -> remove()
                "3" -> edit()
                "4" -> show()
                "5" -> showAll()
                "6" -> break@loop
                else -> println("Try once more")
            }
        }
    }
}
