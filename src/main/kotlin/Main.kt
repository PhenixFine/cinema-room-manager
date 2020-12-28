fun main() {
    val rows = getNum("Enter the number of rows:")
    val seats = getNum("Enter the number of seats in each row:")
    val totalSeats = rows * seats

    if (rows < 1 || seats < 1) {
        println("please enter positive numbers greater than zero for rows and seats.")
        main()
    } else {
        val theater = Array(rows) { Array(seats) { 'S' } }

        printSeats(theater)
        reserveSeat(theater, totalSeats)
        printSeats(theater)
    }
}

fun getNum(text: String, defaultMessage: Boolean = false): Int {
    val strErrorNum = " was not a number, please try again: "
    var num = text
    var default = defaultMessage

    do {
        num = getString(if (default) num + strErrorNum else num)
        if (!default) default = true
    } while (!isNumber(num))

    return num.toInt()
}

fun printSeats(theater: Array<Array<Char>>) {
    print("\nCinema:\n ")
    for (num in theater[0].indices) print(" ${num + 1}")
    println()

    for (rowNum in theater.indices) {
        print(rowNum + 1)
        for (seat in theater[rowNum]) print(" $seat")
        println()
    }
}

fun reserveSeat(theater: Array<Array<Char>>, totalSeats: Int) {
    try {
        val row = getNum("\nEnter a row number:")
        val seat = getNum("Enter a seat number in that row:")
        val price = if (totalSeats > 60 && row > theater.size / 2) 8 else 10

        theater[row - 1][seat - 1] = 'B'
        println("\nTicket price: $$price")
    } catch (e: IndexOutOfBoundsException) {
        println("Please enter numbers within 1 and ${theater.size} for rows, and 1 and ${theater[0].size} for seats.")
        reserveSeat(theater, totalSeats)
    }
}

fun getString(text: String): String {
    println(text)
    return readLine()!!
}

fun isNumber(number: String) = number.toIntOrNull() != null