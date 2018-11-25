package com.formichelli.dailycodingproblem.day1to100.day1to100.day41to50

/*
Given a array of numbers representing the stock prices of a company in chronological order, write a function that calculates the maximum profit you could have made from buying and selling that stock once. You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.
*/
object Day47 {
    fun solution(numbers: IntArray): Int {
        val minFromStart = IntArray(numbers.size)
        val maxFromEnd = IntArray(numbers.size)
        var currentMin = Int.MAX_VALUE
        var currentMax = Int.MIN_VALUE
        for (i in 0 until numbers.size) {
            if (numbers[i] < currentMin) {
                currentMin = numbers[i]
            }

            if (numbers[numbers.size - i - 1] > currentMax) {
                currentMax = numbers[numbers.size - i - 1]
            }

            minFromStart[i] = currentMin
            maxFromEnd[numbers.size - i - 1] = currentMax
        }

        var maxProfit = 0
        for (i in 0 until numbers.size) {
            maxProfit = Math.max(maxProfit, maxFromEnd[i] - minFromStart[i])
        }

        return maxProfit
    }
}
