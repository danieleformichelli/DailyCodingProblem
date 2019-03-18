package com.formichelli.dailycodingproblem.day101to200.day121to130

/*
Given a string, return whether it represents a number. Here are the different kinds of numbers:

"10", a positive integer
"-10", a negative integer
"10.1", a positive real number
"-10.1", a negative real number
"1e5", a number in scientific notation
And here are examples of non-numbers:

"a"
"x 1"
"a -2"
"-"
*/
object Day123 {
    fun solution(numberStr: String): Boolean {
        val startIndex = if (numberStr.startsWith("-") || numberStr.startsWith("+")) 1 else 0
        var hasNumber = false
        var hasDot = false
        var hasNumberBeforeDot = false
        var hasNumberAfterDot = false
        var hasE = false
        var hasNumberBeforeE = false
        var hasNumberAfterE = false
        for (i in startIndex until numberStr.length) {
            when (numberStr[i]) {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                    hasNumber = true
                    if (!hasDot) {
                        hasNumberBeforeDot = true
                    } else {
                        hasNumberAfterDot = true
                    }
                    if (!hasE) {
                        hasNumberBeforeE = true
                    } else {
                        hasNumberAfterE = true
                    }
                }
                '.' -> hasDot = true
                'e' -> hasE = true
                else -> return false
            }
        }

        if (hasDot && (!hasNumberBeforeDot || !hasNumberAfterDot)) {
            // if it has a dot, it must have numbers before and after it
            return false
        }

        if (hasE && (!hasNumberBeforeE || !hasNumberAfterE)) {
            // if it has a e, it must have numbers before and after it
            return false
        }

        return hasNumber
    }
}