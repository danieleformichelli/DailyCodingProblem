package com.formichelli.dailycodingproblem.day41to50

import java.util.*

/*
Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, implement a function rand7() that returns an integer from 1 to 7 (inclusive).
*/
object Day45 {
    private val rand = Random()

    private fun rand5(): Int = rand.nextInt(5) + 1

    fun solution(): Int {
        var rand25 = 25
        while (rand25 >= 22) {
            rand25 = 5 * (rand5() - 1) + rand5()
        }

        return rand25 % 7
    }
}
