package com.formichelli.dailycodingproblem.day1to100.day61to70


/*
Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.

Do this faster than the naive method of repeated multiplication.

For example, pow(2, 10) should return 1024.
*/
object Day61 {
    fun solution(base: Int, exp: Int): Int {
        if (exp == 0)
            return 1

        val halfPower = solution(base, exp / 2)
        return if (exp % 2 == 0)
            halfPower * halfPower
        else
            base * halfPower * halfPower
    }
}
