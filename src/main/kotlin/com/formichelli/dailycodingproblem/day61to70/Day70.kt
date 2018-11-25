package com.formichelli.dailycodingproblem.day61to70

/*
A number is considered perfect if its digits sum up to exactly 10.

Given a positive integer n, return the n-th perfect number.

For example, given 1, you should return 19. Given 2, you should return 28.
*/
object Day70 {
    fun solution(n: Int): Int {
        // All perfect number are a multiple of 9 plus 10
        var perfectNumberCandidate = 19
        var currentN = 1
        while (currentN < n) {
            perfectNumberCandidate += 9
            if (isPerfect(perfectNumberCandidate)) {
                ++currentN
            }
        }

        return perfectNumberCandidate
    }

    private fun isPerfect(perfectNumberCandidate: Int): Boolean {
        var digitsSum = 0
        var remainingDigits = perfectNumberCandidate
        while (remainingDigits != 0) {
            digitsSum += remainingDigits % 10
            remainingDigits /= 10
        }

        return digitsSum == 10
    }
}
