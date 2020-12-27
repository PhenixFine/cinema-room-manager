fun main() {
    val rows = getNum("Enter the number of rows:")
    val seats = getNum("Enter the number of seats in each row:")
    val totalSeats = rows * seats
    val totalIncome = if (totalSeats > 60) rows / 2 * 10 * seats +
            (rows / 2 + rows % 2) * 8 * seats else totalSeats * 10

    println("Total income:\n$$totalIncome")
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

fun getString(text: String): String {
    println(text)
    return readLine()!!
}

fun isNumber(number: String) = number.toIntOrNull() != null