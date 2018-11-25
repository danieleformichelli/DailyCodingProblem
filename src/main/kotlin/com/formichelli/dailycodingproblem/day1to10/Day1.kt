package com.formichelli.dailycodingproblem.day1to10

import java.util.*

/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
 */
object Day1 {
    fun solution(k: Int, numbers: IntArray): Boolean {
        val numbersSet = HashSet<Int>()
        numbers.forEach { number ->
            if (numbersSet.contains(k - number)) {
                return true
            } else {
                numbersSet.add(number)
            }
        }

        return false
    }
}
