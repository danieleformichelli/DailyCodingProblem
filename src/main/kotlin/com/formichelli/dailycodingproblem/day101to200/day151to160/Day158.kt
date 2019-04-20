package com.formichelli.dailycodingproblem.day101to200.day151to160

/*
You are given an N by M matrix of 0s and 1s. Starting from the top left corner, how many ways are there to reach the bottom right corner?

You can only move right and down. 0 represents an empty space while 1 represents a wall you cannot walk through.

For example, given the following matrix:

[[0, 0, 1],
 [0, 0, 1],
 [1, 0, 0]]
Return two, as there are only two ways to get to the bottom right:

Right, down, down, right
Down, right, down, right
The top left corner and bottom right corner will always be 0.
*/
object Day158 {
    fun solution(matrix: Array<IntArray>): Int {
        return solutionHelper(matrix, 0, 0, HashMap())
    }

    private fun solutionHelper(matrix: Array<IntArray>, r: Int, c: Int, memo: HashMap<Pair<Int, Int>, Int>): Int {
        if (r >= matrix.size || c >= matrix[r].size) {
            return 0
        }

        if (matrix[r][c] == 1) {
            // wall
            return 0
        }

        if (r == matrix.lastIndex && c == matrix[r].lastIndex) {
            return 1
        }

        val position = Pair(r, c)
        if (memo.containsKey(position)) {
            return memo[position]!!
        }

        val totalMovingDown = solutionHelper(matrix, r + 1, c, memo)
        val totalMovingRight = solutionHelper(matrix, r, c + 1, memo)
        val total = totalMovingDown + totalMovingRight
        memo[position] = total
        return total
    }
}