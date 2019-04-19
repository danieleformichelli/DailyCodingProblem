package com.formichelli.dailycodingproblem.day101to200.day141to150

/*
Gray code is a binary code where each successive value differ in only one bit, as well as when wrapping around. Gray code is common in hardware so that we don't see temporary spurious values during transitions.

Given a number of bits n, generate a possible gray code for it.

For example, for n = 2, one gray code would be [00, 01, 11, 10].
*/
object Day148 {
    fun solution(n: Int): List<Int> {
        return solutionHelper(n)
    }

    private fun solutionHelper(n: Int): MutableList<Int> {
        if (n == 1) {
            return mutableListOf(0, 1)
        }

        val codes = solutionHelper(n - 1)
        val mask = 1.shl(n - 1)
        for (i in codes.lastIndex downTo 0) {
            // add ocdes from n-1 in reversed order and add a 1 before them
            codes.add(codes[i].or(mask))
        }

        return codes
    }
}