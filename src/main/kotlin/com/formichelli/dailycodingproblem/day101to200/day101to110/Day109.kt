package com.formichelli.dailycodingproblem.day101to200.day101to110

/*
Given an unsigned 8-bit integer, swap its even and odd bits. The 1st and 2nd bit should be swapped, the 3rd and 4th bit should be swapped, and so on.

For example, 10101010 should be 01010101. 11100010 should be 11010001.

Bonus: Can you do this in one line?
*/
object Day109 {
    fun solution(number: Int): Int {
        return number.and(0b01010101).shl(1).or(number.and(0b10101010).shr(1))
    }
}