package com.formichelli.dailycodingproblem.day1to100.day41to50

import java.util.*

/*
Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, implement a function rand7() that returns an integer from 1 to 7 (inclusive).
*/
object Day45 {
    private val rand = Random()

    private fun rand5(): Int = rand.nextInt(5) + 1

    fun solution(): Int {
        var rand25: Int
        do {
            // generate a random number between 1 and 25
            rand25 = 5 * (rand5() - 1) + rand5()
        } while (rand25 >= 22) // discard result if it is not between 1 and 21

        // move to [1,21] to [1,7] interval using modulo 7
        return rand25 % 7
    }
}
