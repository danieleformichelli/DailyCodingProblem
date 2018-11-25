package com.formichelli.dailycodingproblem.day1to100.day81to90

/*
Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0, using only mathematical or bit operations. You can assume b can only be 1 or 0.
*/
object Day85 {
    fun solution(x: Int, y: Int, b: Int): Int {
        // if b is 0, then -b is 0 which means all bits are set to 0
        // if b is 1, then -b is -1 which means all bits are set to 1
        // if b is 0, then b-1 is -1 which means all bits are set to 1
        // if b is 1, then b-1 is 0 which means all bits are set to 0
        return x.and(-b).or(y.and(b - 1))
    }
}