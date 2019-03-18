package com.formichelli.dailycodingproblem.day101to200.day121to130

/*
You are given a 2-d matrix where each cell represents number of coins in that cell. Assuming we start at matrix[0][0], and can only move right or down, find the maximum number of coins you can collect by the bottom right corner.

For example, in this matrix

0 3 1 1
2 0 0 4
1 5 3 1
The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.
*/
object Day122 {
    fun solution(coins: Array<IntArray>): Int {
        return solutionHelper(coins, 0, 0, Array(coins.size) { IntArray(coins[0].size) { -1 } })
    }

    private fun solutionHelper(coins: Array<IntArray>, r: Int, c: Int, memo: Array<IntArray>): Int {
        if (r >= coins.size || c >= coins[r].size) {
            return 0
        }

        if (memo[r][c] == -1) {
            memo[r][c] = coins[r][c] + Math.max(solutionHelper(coins, r + 1, c, memo), solutionHelper(coins, r, c + 1, memo))
        }

        return memo[r][c]
    }
}