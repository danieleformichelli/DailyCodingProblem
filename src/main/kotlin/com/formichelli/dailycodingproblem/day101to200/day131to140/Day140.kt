package com.formichelli.dailycodingproblem.day101to200.day131to140

import java.util.*

/*
Given an array of integers in which two elements appear exactly once and all other elements appear exactly twice, find the two elements that appear only once.

For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.

Follow-up: Can you do this in linear time and constant space?
*/
object Day140 {
    private fun IntArray.xor() = Arrays.stream(this).reduce { left, right -> left.xor(right) }.asInt

    fun solution(numbers: IntArray): Pair<Int, Int> {
        // find all different bits
        val xorResult = numbers.xor()

        val firstDifferentBit = xorResult.and((xorResult - 1).inv())

        val firstElem = Arrays.stream(numbers).filter { it.and(firstDifferentBit) != 0 }.toArray().xor()
        val secondElem = Arrays.stream(numbers).filter { it.and(firstDifferentBit) == 0 }.toArray().xor()

        return Pair(firstElem, secondElem)
    }
}