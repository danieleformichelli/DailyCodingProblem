package com.formichelli.dailycodingproblem.day81to90

import java.util.*

/*
Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number could represent. You can assume each valid number in the mapping is a single digit.

For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].
*/
object Day81 {
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
