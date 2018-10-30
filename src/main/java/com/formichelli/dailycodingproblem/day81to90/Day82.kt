package com.formichelli.dailycodingproblem.day81to90

import java.util.*

/*
Using a read7() method that returns 7 characters from a file, implement readN(n) which reads n characters.

For example, given a file with the content “Hello world”, three read7() returns “Hello w”, “orld” and then “”.
*/
object Day82 {
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
