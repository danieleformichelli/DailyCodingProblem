package com.formichelli.dailycodingproblem.day61to70

/*
There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting at the top-left corner and getting to the bottom-right corner. You can only move right or down.

For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:

Right, then down
Down, then right
Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.
*/
object Day62 {
    fun solution(N: Int, M: Int): Int {
        return solutionHelper(Array(N) { IntArray(M) }, 0, 0)
    }

    private fun solutionHelper(partialSolutions: Array<IntArray>, row: Int, column: Int): Int {
        if (row == partialSolutions.lastIndex && column == partialSolutions[row].lastIndex) {
            return 1
        }

        if (row > partialSolutions.lastIndex) {
            return 0
        }

        if (column > partialSolutions[row].lastIndex) {
            return 0
        }

        return solutionHelper(partialSolutions, row + 1, column) + solutionHelper(partialSolutions, row, column + 1)
    }
}
