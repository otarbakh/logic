package com.example.logic


val numbers = mutableListOf<Int>(1, 2, 4)
fun main() {

//println(countWaysToReachNthStair(5))
//    println(isBracesCorrect("()"))
//    findMinimumMissingNumber(numbers)
//    calculateMinimumCoins(324)
}


fun calculateMinimumCoins(coin: Int) {
    var currentCoins = coin //220
    var numCoins = 0 //4


    numCoins += currentCoins / 50 // Add the number of 50 cent coins
    currentCoins %= 50 // Calculate the remaining cents

    numCoins += currentCoins / 20 // Add the number of 20 cent coins
    currentCoins %= 20 // Calculate the remaining cents

    numCoins += currentCoins / 10 // Add the number of 10 cent coins
    currentCoins %= 10 // Calculate the remaining cents

    numCoins += currentCoins / 5 // Add the number of 5 cent coins
    currentCoins %= 5 // Calculate the remaining cents

    numCoins += currentCoins // Add the number of 1 cent coins

    println(numCoins)  // Return the total number of coins
}

fun findMinimumMissingNumber(list: List<Int>) {
    val set = list.toSet()
    var i = 1
    while (set.contains(i)) {
        i++
    }
    println(i)
}

fun isBracesCorrect(str: String): Boolean {
    val braces = mutableListOf<Char>()
    for (i in str) {
        when (i) {
            '(' -> braces.add(i)
            ')' -> if (braces.isNotEmpty() && braces.last() == '(') {
                braces.removeAt(braces.size - 1)
            } else {
                return false
            }
        }
    }
    return braces.isEmpty()
}

fun countWaysToReachNthStair(n: Int): Int {
    if (n <= 1) {
        return 1
    }
    var prev1 = 1
    var prev2 = 1
    var ways = 0
    for (i in 2..n) {
        ways = prev1 + prev2
        prev2 = prev1
        prev1 = ways
    }
    return ways
}


