package com.formichelli.dailycodingproblem.day71to80

import java.util.*

/*
Using a function rand7() that returns an integer from 1 to 7 (inclusive) with uniform probability, implement a function rand5() that returns an integer from 1 to 5 (inclusive).
*/
object Day71 {
    private val rand = Random()
    private fun rand7() = rand.nextInt(7) + 1

    fun solution(): Int {
        var rand5: Int
        do {
            rand5 = rand7()
        } while (rand5 !in 1..5)

        return rand5
    }
}
