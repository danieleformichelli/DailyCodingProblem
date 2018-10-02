package com.formichelli.dailycodingproblem.day41to50

/*
Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length, return any one.

For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana".
*/
object Day46 {
    fun solution(inputString: String): String {
        var longestPalindromeStart = 0
        var longestPalindromeLength = 1
        for (i in 1 until inputString.length) {
            // find the longest palindrome with center in i
            for (j in 1 until Math.min(i + 1, inputString.length - i)) {
                if (inputString[i - j] == inputString[i + j]) {
                    val currentPalindromeLength = 1 + 2 * (j)
                    if (currentPalindromeLength > longestPalindromeLength) {
                        longestPalindromeStart = i - j
                        longestPalindromeLength = currentPalindromeLength
                    }
                } else {
                    break
                }
            }

            // find the longest palindrome with center in i and i - 1
            if (inputString[i] == inputString[i - 1]) {
                for (j in 1 until Math.min(i, inputString.length - i)) {
                    if (inputString[i - 1 - j] == inputString[i + j]) {
                        val currentPalindromeLength = 2 + 2 * j
                        if (currentPalindromeLength > longestPalindromeLength) {
                            longestPalindromeStart = i - 1 - j
                            longestPalindromeLength = currentPalindromeLength
                        }
                    } else {
                        break
                    }
                }
            }
        }

        return inputString.substring(longestPalindromeStart, longestPalindromeStart + longestPalindromeLength)
    }
}
