package com.formichelli.dailycodingproblem.day1to100.day1to100.day71to80

/*
Given an array of numbers, find the length of the longest increasing subsequence in the array. The subsequence does not necessarily have to be contiguous.

For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.
*/
object Day75 {
    fun solution(numbers: IntArray): Int {
        return solutionHelper(numbers, 0, Int.MIN_VALUE)
    }

    private fun solutionHelper(numbers: IntArray, index: Int, currentMax: Int): Int {
        if (index == numbers.size) {
            return 0
        }

        val longestWithNumberAtIndex = if (numbers[index] > currentMax) {
            1 + solutionHelper(numbers, index + 1, numbers[index])
        } else {
            Int.MIN_VALUE
        }
        val longestWithoutNumberAtIndex = solutionHelper(numbers, index + 1, currentMax)

        return Math.max(longestWithNumberAtIndex, longestWithoutNumberAtIndex)
    }
}
