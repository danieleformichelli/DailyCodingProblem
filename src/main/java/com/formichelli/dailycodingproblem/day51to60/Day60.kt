package com.formichelli.dailycodingproblem.day51to60

/*
Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.

For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.

Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that add up to the same sum.
*/
object Day60 {
    fun solution(numbers: List<Int>): Boolean {
        return solutionHelper(numbers, BooleanArray(numbers.size), 0)
    }

    fun solutionHelper(numbers: List<Int>, splitIndexes: BooleanArray, currentIndex: Int): Boolean {
        if (currentIndex == numbers.size) {
            return false
        }

        if (sumMatches(numbers, splitIndexes)) {
            return true
        }

        splitIndexes[currentIndex] = true
        val result = solutionHelper(numbers, splitIndexes, currentIndex + 1)
        if (result) {
            return true
        }

        splitIndexes[currentIndex] = false
        return solutionHelper(numbers, splitIndexes, currentIndex + 1)
    }

    private fun sumMatches(numbers: List<Int>, splitIndexes: BooleanArray): Boolean {
        var trueSum = 0
        var falseSum = 0
        numbers.forEachIndexed { index, number ->
            if (splitIndexes[index]) {
                trueSum += number
            } else {
                falseSum += number
            }
        }

        return trueSum == falseSum
    }
}
