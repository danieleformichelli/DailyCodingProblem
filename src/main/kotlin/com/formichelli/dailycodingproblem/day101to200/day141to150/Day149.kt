package com.formichelli.dailycodingproblem.day101to200.day141to150

/*
Given a list of numbers L, implement a method sum(i, j) which returns the sum from the sublist L[i:j] (including i, excluding j).

For example, given L = [1, 2, 3, 4, 5], sum(1, 3) should return sum([2, 3]), which is 5.

You can assume that you can do some pre-processing. sum() should be optimized over the pre-processing step.
*/
object Day149 {
    fun solution(numbers: List<Int>, i: Int, j: Int): Int {
        if (j <= i) {
            throw IllegalArgumentException()
        }

        val sums = preprocess(numbers)

        return if (i == 0) {
            sums[j - 1]
        } else {
            sums[j - 1] - sums[i - 1]
        }
    }

    private fun preprocess(numbers: List<Int>): List<Int> {
        val result = ArrayList<Int>(numbers.size)
        var currentSum = 0
        for (i in 0 until numbers.size) {
            currentSum += numbers[i]
            result.add(currentSum)
        }

        return result
    }
}