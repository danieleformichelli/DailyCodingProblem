package com.formichelli.dailycodingproblem.day101to200.day101to110

import java.util.*

/*
Given a list of integers and a number K, return which contiguous elements of the list sum to K.

For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4].
*/
object Day102 {
    fun solution(numbers: List<Int>, K: Int): List<Int> {
        val sums = LinkedList<Int>()
        for (i in 0 until numbers.size) {
            for (j in 0 until sums.size) {
                sums[j] += numbers[i]
            }
            sums.add(numbers[i])
            while (sums[0] > K) {
                sums.removeFirst()
            }

            if (sums[0] == K) {
                return numbers.subList(i - (sums.size - 1), i + 1)
            }
        }

        return listOf()
    }
}