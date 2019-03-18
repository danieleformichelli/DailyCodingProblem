package com.formichelli.dailycodingproblem.day101to200.day121to130

/*
Given a string which we can delete at most k, return whether you can make a palindrome.

For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
*/
object Day121 {
    fun solution(string: String, k: Int): Boolean {
        val reversed = string.reversed()
        val lcs = findLongestCommonSubsequence(string, reversed)
        return string.length - lcs <= k
    }

    private fun findLongestCommonSubsequence(string: String, reversed: String): Int {
        val matrix = Array(string.length + 1) { IntArray(string.length + 1) { 0 } }
        for (i in 1..string.length) {
            for (j in 1..string.length) {
                if (string[i - 1] == reversed[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1])
                }
            }
        }

        return matrix[string.length][string.length]
    }
}