package com.formichelli.dailycodingproblem.day1to100.day1to100.day81to90

import java.util.*

/*
Given an integer n and a list of integers l, write a function that randomly generates a number from 0 to n-1 that isn't in l (uniform).
*/
object Day90 {
    fun solution(n: Int, l: List<Int>): Int {
        val rand = Random()

        // could be more efficient
        var randNum: Int
        do {
            randNum = rand.nextInt(n)
        } while (l.contains(randNum))

        return randNum
    }
}
