package com.formichelli.dailycodingproblem.day101to200.day121to130

/*
Given a real number n, find the square root of n. For example, given n = 9, return 3.
*/
object Day129 {
    fun solution(n: Int): Int {
        return solutionHelper(n, 1, (n + 1) / 2)
    }

    private fun solutionHelper(n: Int, min: Int, max: Int): Int {
        if (min > max) {
            return -1
        }

        val next = (min + max) / 2
        val square = next * next
        return when {
            square == n -> next
            square < n -> solutionHelper(n, next + 1, max)
            else -> solutionHelper(n, min, next - 1)
        }
    }
}