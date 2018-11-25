package com.formichelli.dailycodingproblem.day1to100.day81to90

/*
Implement division of two positive integers without using the division, multiplication, or modulus operators. Return the quotient as an integer, ignoring the remainder.
*/
object Day88 {
    fun solution(dividend: Int, divisor: Int): Int {
        var quotient = 0
        var remainingDividend = dividend
        while (remainingDividend >= divisor) {
            remainingDividend -= divisor
            ++quotient
        }

        return quotient
    }
}