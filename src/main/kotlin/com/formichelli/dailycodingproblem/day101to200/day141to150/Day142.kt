package com.formichelli.dailycodingproblem.day101to200.day141to150

/*
You're given a string consisting solely of (, ), and *. * can represent either a (, ), or an empty string. Determine whether the parentheses are balanced.

For example, (()* and (*) are balanced. )*( is not balanced.
*/
object Day142 {
    fun solution(str: String): Boolean {
        var openCount = 0
        var closeCount = 0
        var starCount = 0
        str.forEach {
            when (it) {
                '(' -> {
                    ++openCount
                    if (!isValidSoFar(openCount, closeCount, starCount)) {
                        return false
                    }
                }
                ')' -> {
                    ++closeCount
                    if (!isValidSoFar(openCount, closeCount, starCount)) {
                        return false
                    }
                }
                else -> {
                    ++starCount
                    if (!isValidSoFar(openCount, closeCount, starCount)) {
                        return false
                    }
                }
            }
        }

        return isValid(openCount, closeCount, starCount)
    }

    private fun isValidSoFar(openCount: Int, closeCount: Int, starCount: Int): Boolean {
        return openCount + starCount >= closeCount
    }

    private fun isValid(openCount: Int, closeCount: Int, starCount: Int): Boolean {
        return openCount + starCount >= closeCount && openCount <= closeCount + starCount
    }
}