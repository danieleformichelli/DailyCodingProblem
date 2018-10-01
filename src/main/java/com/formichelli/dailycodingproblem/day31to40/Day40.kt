package com.formichelli.dailycodingproblem.day31to40

/*
Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.
*/
object Day40 {
    // TODO the space is O(N) instead of O(1)
    fun solution(numbers: IntArray): Int {
        val numbersCount = HashMap<Int, Int>()

        // O(N)
        numbers.forEach {
            val count = numbersCount.getOrDefault(it, 0)
            numbersCount[it] = count + 1
        }

        // O(N)
        return numbersCount.filter { it.value == 1 }.keys.first()
    }
}
