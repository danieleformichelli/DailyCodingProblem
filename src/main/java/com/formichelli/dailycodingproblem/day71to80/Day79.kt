package com.formichelli.dailycodingproblem.day71to80

/*
Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.

For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.

Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.
*/
object Day79 {
    fun solution(numbers: IntArray): Boolean {
        var modified = false
        for (i in 0 until numbers.size - 1) {
            if (numbers[i] > numbers[i + 1]) {
                if (modified) {
                    return false
                }

                when {
                    i == 0 -> numbers[i] = Int.MIN_VALUE
                    numbers[i - 1] <= numbers[i + 1] -> numbers[i] = numbers[i - 1]
                    else -> numbers[i + 1] = numbers[i]
                }
                modified = true
            }
        }

        return true
    }
}
