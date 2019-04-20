package com.formichelli.dailycodingproblem.day101to200.day151to160

/*
Given a positive integer n, find the smallest number of squared integers which sum to n.

For example, given n = 13, return 2 since 13 = 3^2 + 2^2 = 9 + 4.

Given n = 27, return 3 since 27 = 3^2 + 3^2 + 3^2 = 9 + 9 + 9.
*/
object Day156 {
    fun solution(number: Int): Int {
        return solutionHelper(number, HashMap())
    }

    private fun solutionHelper(number: Int, memo: HashMap<Int, Int>): Int {
        if (number == 0) {
            return 0
        }

        if (memo.containsKey(number)) {
            return number
        }

        val biggerToBeSquared = Math.floor(Math.sqrt(number.toDouble())).toInt()
        var min = Int.MAX_VALUE
        for (i in biggerToBeSquared downTo 1) {
            val squaredCount = 1 + solutionHelper(number - i * i, memo)
            min = Math.min(min, squaredCount)
        }

        memo[number] = min
        return min
    }
}