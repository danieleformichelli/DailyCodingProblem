package com.formichelli.dailycodingproblem.day41to50

import java.util.*

/*
Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, implement a function rand7() that returns an integer from 1 to 7 (inclusive).
*/
object Day48 {
    private val rand = Random()

    private fun rand5() {
        rand.nextInt(5) + 1
    }

    fun solution(number: IntArray): Int {
        return 0
    }
}
