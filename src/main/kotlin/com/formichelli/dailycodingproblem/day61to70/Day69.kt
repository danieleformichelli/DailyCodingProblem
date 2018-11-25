package com.formichelli.dailycodingproblem.day61to70

/*
Given a list of integers, return the largest product that can be made by multiplying any three integers.

For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.

You can assume the list has at least three integers.
*/
object Day69 {
    fun solution(numbers: List<Int>): Int {
        val sortedNumbers = numbers.sorted()
        val biggestNumber = sortedNumbers.last()

        return if (biggestNumber >= 0) {
            val smallestTwoProduct = sortedNumbers[0] * sortedNumbers[1]
            val secondAndThirdBiggestTwoProduct = sortedNumbers[sortedNumbers.size - 2] * sortedNumbers[sortedNumbers.size - 3]
            biggestNumber * Math.max(smallestTwoProduct, secondAndThirdBiggestTwoProduct)
        } else {
            sortedNumbers[sortedNumbers.size - 1] * sortedNumbers[sortedNumbers.size - 2] * sortedNumbers[sortedNumbers.size - 3]
        }
    }
}
