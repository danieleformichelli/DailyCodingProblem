package com.formichelli.dailycodingproblem.day1to100.day1to100.day31to40

/*
Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.
*/
object Day40 {
    fun solution(numbers: IntArray): Int {
        val bitCount = 32

        // count how many times each bit is set
        val bitSum = IntArray(bitCount)
        for (number in numbers) {
            for (i in 0 until 32) {
                bitSum[i] += number.shr(i).and(1)
            }
        }

        // consider the bits which don't appear a multiple of 4 times
        var ret = 0
        for (i in 0 until 32) {
            ret = ret.or((bitSum[i] % 3).shl(i))
        }

        return ret
    }
}
